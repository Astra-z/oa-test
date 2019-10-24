package com.study.oa.biz;

import com.study.oa.entity.ClaimVoucher;
import com.study.oa.entity.ClaimVoucherItem;
import com.study.oa.entity.DealRecord;

import java.util.List;

public interface ClaimVoucherBiz {
    void save(ClaimVoucher claimVoucher, List<ClaimVoucherItem> claimVoucherItem);
    ClaimVoucher get (int id);
    List<ClaimVoucherItem> getItems(int cvid);
    List<DealRecord> getRecords(int cvid);

    List<ClaimVoucher> getSelf(String sn);
    List<ClaimVoucher> getDeal(String sn);

    void update(ClaimVoucher claimVoucher,List<ClaimVoucherItem> claimVoucherItems);
    void submit(int id);
    void deal(DealRecord dealRecord);
}
