package com.study.oa.controller;

import com.study.oa.biz.ClaimVoucherBiz;
import com.study.oa.dto.ClaimVoucherInfo;
import com.study.oa.entity.DealRecord;
import com.study.oa.entity.Employee;
import com.study.oa.global.Contant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
@RequestMapping("/claim_voucher")
public class ClaimVoucherController {
    @Autowired
    ClaimVoucherBiz claimVoucherBiz;

    @RequestMapping("/to_add")
    public String toAdd(Map<String,Object> map){
        map.put("items", Contant.getItems());
        map.put("info",new ClaimVoucherInfo());
        return "claim_voucher_add";
    }

    @RequestMapping("/add")
    public String add(ClaimVoucherInfo info, HttpSession session){
        Employee employee= (Employee) session.getAttribute("employee");
        info.getClaimVoucher().setCreateSn(employee.getSn());
        claimVoucherBiz.save(info.getClaimVoucher(),info.getItems());
        return "redirect:deal";
    }

    @RequestMapping("/detail")
    public String detail(Map<String,Object> map,int id){
        map.put("claimVoucher",claimVoucherBiz.get(id));
        map.put("items",claimVoucherBiz.getItems(id));
        map.put("records",claimVoucherBiz.getRecords(id));
        return "claim_voucher_detail";
    }

    @RequestMapping("/self")
    public String self(HttpSession session,Map<String,Object> map){
        Employee employee= (Employee) session.getAttribute("employee");

        map.put("list",claimVoucherBiz.getSelf(employee.getSn()));
        return "claim_voucher_self";
    }

    @RequestMapping("/deal")
    public String deal(HttpSession session,Map<String,Object> map){
        Employee employee= (Employee) session.getAttribute("employee");
        map.put("deal_list",claimVoucherBiz.getDeal(employee.getSn()));
        return "claim_voucher_deal";
    }

    @RequestMapping("/to_update")
    public String toUpdate(@RequestParam int id,Map<String,Object> map){
        map.put("items",Contant.getItems());
        ClaimVoucherInfo info=new ClaimVoucherInfo();
        info.setClaimVoucher(claimVoucherBiz.get(id));
        info.setItems(claimVoucherBiz.getItems(id));
        map.put("info",info);
        return "claim_voucher_update";
    }
    @RequestMapping("/update")
    public String update(ClaimVoucherInfo info, HttpSession session){
        Employee employee= (Employee) session.getAttribute("employee");
        info.getClaimVoucher().setCreateSn(employee.getSn());
        claimVoucherBiz.update(info.getClaimVoucher(),info.getItems());
        return "redirect:deal";
    }

    @RequestMapping("/submit")
    public String submit(@RequestParam int id){
        claimVoucherBiz.submit(id);
        return"redirect:deal";
    }

    @RequestMapping("/to_check")
    public String toCheck(Map<String,Object> map,int id){
        map.put("claimVoucher",claimVoucherBiz.get(id));
        map.put("items",claimVoucherBiz.getItems(id));
        map.put("records",claimVoucherBiz.getRecords(id));
        DealRecord dealRecord=new DealRecord();
        dealRecord.setClaimVoucherId(id);
        map.put("record",dealRecord);
        return"claim_voucher_check";
    }

    @RequestMapping("/check")
    public String Check(DealRecord record ,HttpSession session){
        Employee employee= (Employee) session.getAttribute("employee");
//        System.out.println(record.);
        record.setDealSn(employee.getSn());
        claimVoucherBiz.deal(record);
        return"redirect:deal";
    }
}
