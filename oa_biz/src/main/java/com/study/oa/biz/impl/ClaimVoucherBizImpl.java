package com.study.oa.biz.impl;

import com.study.oa.biz.ClaimVoucherBiz;
import com.study.oa.dao.ClaimVoucherDao;
import com.study.oa.dao.ClaimVoucherItemDao;
import com.study.oa.dao.DealRecordDao;
import com.study.oa.dao.EmployeeDao;
import com.study.oa.entity.ClaimVoucher;
import com.study.oa.entity.ClaimVoucherItem;
import com.study.oa.entity.DealRecord;
import com.study.oa.entity.Employee;
import com.study.oa.global.Contant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ClaimVoucherBizImpl implements ClaimVoucherBiz {
    @Autowired
    private ClaimVoucherDao claimVoucherDao;
    @Autowired
    private ClaimVoucherItemDao claimVoucherItemDao;
    @Autowired
    private DealRecordDao dealRecordDao;
    @Autowired
    private EmployeeDao employeeDao;
    public void save(ClaimVoucher claimVoucher, List<ClaimVoucherItem> claimVoucherItem) {
        claimVoucher.setCreateTime(new Date());
        claimVoucher.setNextDealSn(claimVoucher.getCreateSn());
        claimVoucher.setStatus(Contant.CLAIMVOUCHER_CREATE);
        claimVoucherDao.insert(claimVoucher);

        for(ClaimVoucherItem items:claimVoucherItem){
            items.setClaimVoucherId(claimVoucher.getId());
            claimVoucherItemDao.insert(items);
        }
    }

    public ClaimVoucher get(int id) {
        return claimVoucherDao.select(id);
    }

    public List<ClaimVoucherItem> getItems(int cvid) {
        return claimVoucherItemDao.selectByClaimVoucher(cvid);
    }

    public List<DealRecord> getRecords(int cvid) {
        return dealRecordDao.selectByClaimVoucher(cvid);
    }

    public List<ClaimVoucher> getSelf(String sn) {
        return claimVoucherDao.selectByCreateSn(sn);
    }

    public List<ClaimVoucher> getDeal(String sn) {
        return claimVoucherDao.selectByNextDealSn(sn);
    }

    public void update(ClaimVoucher claimVoucher, List<ClaimVoucherItem> claimVoucherItems) {
        claimVoucher.setNextDealSn(claimVoucher.getCreateSn());
        claimVoucher.setStatus(Contant.CLAIMVOUCHER_CREATE);
        claimVoucherDao.update(claimVoucher);

        List<ClaimVoucherItem> olds=claimVoucherItemDao.selectByClaimVoucher(claimVoucher.getId());
        for(ClaimVoucherItem olditems:olds){
            boolean isHave=false;
            for(ClaimVoucherItem newitems:claimVoucherItems) {
                if(newitems.getId()==olditems.getId()){
                    isHave=true;
                    break;
                }
            }
            if(!isHave){
                claimVoucherDao.delete(olditems.getId());
            }
        }
        for (ClaimVoucherItem newitems:claimVoucherItems){
            newitems.setClaimVoucherId(claimVoucher.getId());
            if(newitems.getId()>0&&newitems.getId()!=null){
                claimVoucherItemDao.update(newitems);
            }
            else {
                claimVoucherItemDao.insert(newitems);
            }
        }
    }

    public void submit(int id) {

        ClaimVoucher claimVoucher=claimVoucherDao.select(id);
        Employee employee=employeeDao.select(claimVoucher.getCreateSn());
        claimVoucher.setStatus(Contant.CLAIMVOUCHER_SUBMIT);
        claimVoucher.setNextDealSn(employeeDao.selectByDepartmentAndPost(employee.getDepartment().getSn(),Contant.POST_FM).get(0).getSn());
        claimVoucherDao.update(claimVoucher);

        DealRecord dealRecord=new DealRecord();
        dealRecord.setDealWay(Contant.DEAL_SUBMIT);
        dealRecord.setDealSn(employee.getSn());
        dealRecord.setDealTime(new Date());
        dealRecord.setClaimVoucherId(id);
        dealRecord.setDealResult(Contant.CLAIMVOUCHER_SUBMIT);
        dealRecord.setComment("无");
        dealRecordDao.insert(dealRecord);
    }

    public void deal(DealRecord dealRecord) {
        ClaimVoucher claimVoucher=claimVoucherDao.select(dealRecord.getClaimVoucherId());
        Employee employee=employeeDao.select(dealRecord.getDealSn());
        if (dealRecord.getDealWay().equals(Contant.DEAL_PASS)){
            if (claimVoucher.getTotalAmount()<=Contant.LIMIT_CHECK||employee.getPost().equals(Contant.POST_GM)){
                claimVoucher.setStatus(Contant.CLAIMVOUCHER_APPROVED);
                claimVoucher.setNextDealSn(employeeDao.selectByDepartmentAndPost(null,Contant.POST_CASHIER).get(0).getSn());

                dealRecord.setDealTime(new Date());
                dealRecord.setDealResult(Contant.CLAIMVOUCHER_APPROVED);
            }
            else {
                claimVoucher.setStatus(Contant.CLAIMVOUCHER_RECHECK);
                claimVoucher.setNextDealSn(employeeDao.selectByDepartmentAndPost(null,Contant.POST_GM).get(0).getSn());

                dealRecord.setDealTime(new Date());
                dealRecord.setDealResult(Contant.CLAIMVOUCHER_RECHECK);
            }
        }
        else if (dealRecord.getDealWay().equals(Contant.DEAL_BACK)){
            claimVoucher.setStatus(Contant.CLAIMVOUCHER_BACK);
            claimVoucher.setNextDealSn(claimVoucher.getCreater().getSn());

            dealRecord.setDealTime(new Date());
            dealRecord.setDealResult(Contant.CLAIMVOUCHER_BACK);
        }
        else if(dealRecord.getDealWay().equals(Contant.DEAL_REJECT)){
            claimVoucher.setStatus(Contant.CLAIMVOUCHER_TERMINATED);
            claimVoucher.setNextDealSn(null);

            dealRecord.setDealTime(new Date());
            dealRecord.setDealResult(Contant.CLAIMVOUCHER_TERMINATED);
        }
        else if(dealRecord.getDealWay().equals(Contant.DEAL_PAID)){
            claimVoucher.setStatus(Contant.CLAIMVOUCHER_PAID);
            claimVoucher.setNextDealSn(null);

            dealRecord.setDealTime(new Date());
            dealRecord.setDealResult(Contant.CLAIMVOUCHER_PAID);
        }

        claimVoucherDao.update(claimVoucher);
        dealRecordDao.insert(dealRecord);
    }
}
