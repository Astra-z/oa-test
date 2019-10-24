package com.study.oa.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DealRecordExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DealRecordExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andClaimVoucherIdIsNull() {
            addCriterion("claim_voucher_id is null");
            return (Criteria) this;
        }

        public Criteria andClaimVoucherIdIsNotNull() {
            addCriterion("claim_voucher_id is not null");
            return (Criteria) this;
        }

        public Criteria andClaimVoucherIdEqualTo(Integer value) {
            addCriterion("claim_voucher_id =", value, "claimVoucherId");
            return (Criteria) this;
        }

        public Criteria andClaimVoucherIdNotEqualTo(Integer value) {
            addCriterion("claim_voucher_id <>", value, "claimVoucherId");
            return (Criteria) this;
        }

        public Criteria andClaimVoucherIdGreaterThan(Integer value) {
            addCriterion("claim_voucher_id >", value, "claimVoucherId");
            return (Criteria) this;
        }

        public Criteria andClaimVoucherIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("claim_voucher_id >=", value, "claimVoucherId");
            return (Criteria) this;
        }

        public Criteria andClaimVoucherIdLessThan(Integer value) {
            addCriterion("claim_voucher_id <", value, "claimVoucherId");
            return (Criteria) this;
        }

        public Criteria andClaimVoucherIdLessThanOrEqualTo(Integer value) {
            addCriterion("claim_voucher_id <=", value, "claimVoucherId");
            return (Criteria) this;
        }

        public Criteria andClaimVoucherIdIn(List<Integer> values) {
            addCriterion("claim_voucher_id in", values, "claimVoucherId");
            return (Criteria) this;
        }

        public Criteria andClaimVoucherIdNotIn(List<Integer> values) {
            addCriterion("claim_voucher_id not in", values, "claimVoucherId");
            return (Criteria) this;
        }

        public Criteria andClaimVoucherIdBetween(Integer value1, Integer value2) {
            addCriterion("claim_voucher_id between", value1, value2, "claimVoucherId");
            return (Criteria) this;
        }

        public Criteria andClaimVoucherIdNotBetween(Integer value1, Integer value2) {
            addCriterion("claim_voucher_id not between", value1, value2, "claimVoucherId");
            return (Criteria) this;
        }

        public Criteria andDealSnIsNull() {
            addCriterion("deal_sn is null");
            return (Criteria) this;
        }

        public Criteria andDealSnIsNotNull() {
            addCriterion("deal_sn is not null");
            return (Criteria) this;
        }

        public Criteria andDealSnEqualTo(String value) {
            addCriterion("deal_sn =", value, "dealSn");
            return (Criteria) this;
        }

        public Criteria andDealSnNotEqualTo(String value) {
            addCriterion("deal_sn <>", value, "dealSn");
            return (Criteria) this;
        }

        public Criteria andDealSnGreaterThan(String value) {
            addCriterion("deal_sn >", value, "dealSn");
            return (Criteria) this;
        }

        public Criteria andDealSnGreaterThanOrEqualTo(String value) {
            addCriterion("deal_sn >=", value, "dealSn");
            return (Criteria) this;
        }

        public Criteria andDealSnLessThan(String value) {
            addCriterion("deal_sn <", value, "dealSn");
            return (Criteria) this;
        }

        public Criteria andDealSnLessThanOrEqualTo(String value) {
            addCriterion("deal_sn <=", value, "dealSn");
            return (Criteria) this;
        }

        public Criteria andDealSnLike(String value) {
            addCriterion("deal_sn like", value, "dealSn");
            return (Criteria) this;
        }

        public Criteria andDealSnNotLike(String value) {
            addCriterion("deal_sn not like", value, "dealSn");
            return (Criteria) this;
        }

        public Criteria andDealSnIn(List<String> values) {
            addCriterion("deal_sn in", values, "dealSn");
            return (Criteria) this;
        }

        public Criteria andDealSnNotIn(List<String> values) {
            addCriterion("deal_sn not in", values, "dealSn");
            return (Criteria) this;
        }

        public Criteria andDealSnBetween(String value1, String value2) {
            addCriterion("deal_sn between", value1, value2, "dealSn");
            return (Criteria) this;
        }

        public Criteria andDealSnNotBetween(String value1, String value2) {
            addCriterion("deal_sn not between", value1, value2, "dealSn");
            return (Criteria) this;
        }

        public Criteria andDealTimeIsNull() {
            addCriterion("deal_time is null");
            return (Criteria) this;
        }

        public Criteria andDealTimeIsNotNull() {
            addCriterion("deal_time is not null");
            return (Criteria) this;
        }

        public Criteria andDealTimeEqualTo(Date value) {
            addCriterion("deal_time =", value, "dealTime");
            return (Criteria) this;
        }

        public Criteria andDealTimeNotEqualTo(Date value) {
            addCriterion("deal_time <>", value, "dealTime");
            return (Criteria) this;
        }

        public Criteria andDealTimeGreaterThan(Date value) {
            addCriterion("deal_time >", value, "dealTime");
            return (Criteria) this;
        }

        public Criteria andDealTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("deal_time >=", value, "dealTime");
            return (Criteria) this;
        }

        public Criteria andDealTimeLessThan(Date value) {
            addCriterion("deal_time <", value, "dealTime");
            return (Criteria) this;
        }

        public Criteria andDealTimeLessThanOrEqualTo(Date value) {
            addCriterion("deal_time <=", value, "dealTime");
            return (Criteria) this;
        }

        public Criteria andDealTimeIn(List<Date> values) {
            addCriterion("deal_time in", values, "dealTime");
            return (Criteria) this;
        }

        public Criteria andDealTimeNotIn(List<Date> values) {
            addCriterion("deal_time not in", values, "dealTime");
            return (Criteria) this;
        }

        public Criteria andDealTimeBetween(Date value1, Date value2) {
            addCriterion("deal_time between", value1, value2, "dealTime");
            return (Criteria) this;
        }

        public Criteria andDealTimeNotBetween(Date value1, Date value2) {
            addCriterion("deal_time not between", value1, value2, "dealTime");
            return (Criteria) this;
        }

        public Criteria andDealWayIsNull() {
            addCriterion("deal_way is null");
            return (Criteria) this;
        }

        public Criteria andDealWayIsNotNull() {
            addCriterion("deal_way is not null");
            return (Criteria) this;
        }

        public Criteria andDealWayEqualTo(String value) {
            addCriterion("deal_way =", value, "dealWay");
            return (Criteria) this;
        }

        public Criteria andDealWayNotEqualTo(String value) {
            addCriterion("deal_way <>", value, "dealWay");
            return (Criteria) this;
        }

        public Criteria andDealWayGreaterThan(String value) {
            addCriterion("deal_way >", value, "dealWay");
            return (Criteria) this;
        }

        public Criteria andDealWayGreaterThanOrEqualTo(String value) {
            addCriterion("deal_way >=", value, "dealWay");
            return (Criteria) this;
        }

        public Criteria andDealWayLessThan(String value) {
            addCriterion("deal_way <", value, "dealWay");
            return (Criteria) this;
        }

        public Criteria andDealWayLessThanOrEqualTo(String value) {
            addCriterion("deal_way <=", value, "dealWay");
            return (Criteria) this;
        }

        public Criteria andDealWayLike(String value) {
            addCriterion("deal_way like", value, "dealWay");
            return (Criteria) this;
        }

        public Criteria andDealWayNotLike(String value) {
            addCriterion("deal_way not like", value, "dealWay");
            return (Criteria) this;
        }

        public Criteria andDealWayIn(List<String> values) {
            addCriterion("deal_way in", values, "dealWay");
            return (Criteria) this;
        }

        public Criteria andDealWayNotIn(List<String> values) {
            addCriterion("deal_way not in", values, "dealWay");
            return (Criteria) this;
        }

        public Criteria andDealWayBetween(String value1, String value2) {
            addCriterion("deal_way between", value1, value2, "dealWay");
            return (Criteria) this;
        }

        public Criteria andDealWayNotBetween(String value1, String value2) {
            addCriterion("deal_way not between", value1, value2, "dealWay");
            return (Criteria) this;
        }

        public Criteria andDealResultIsNull() {
            addCriterion("deal_result is null");
            return (Criteria) this;
        }

        public Criteria andDealResultIsNotNull() {
            addCriterion("deal_result is not null");
            return (Criteria) this;
        }

        public Criteria andDealResultEqualTo(String value) {
            addCriterion("deal_result =", value, "dealResult");
            return (Criteria) this;
        }

        public Criteria andDealResultNotEqualTo(String value) {
            addCriterion("deal_result <>", value, "dealResult");
            return (Criteria) this;
        }

        public Criteria andDealResultGreaterThan(String value) {
            addCriterion("deal_result >", value, "dealResult");
            return (Criteria) this;
        }

        public Criteria andDealResultGreaterThanOrEqualTo(String value) {
            addCriterion("deal_result >=", value, "dealResult");
            return (Criteria) this;
        }

        public Criteria andDealResultLessThan(String value) {
            addCriterion("deal_result <", value, "dealResult");
            return (Criteria) this;
        }

        public Criteria andDealResultLessThanOrEqualTo(String value) {
            addCriterion("deal_result <=", value, "dealResult");
            return (Criteria) this;
        }

        public Criteria andDealResultLike(String value) {
            addCriterion("deal_result like", value, "dealResult");
            return (Criteria) this;
        }

        public Criteria andDealResultNotLike(String value) {
            addCriterion("deal_result not like", value, "dealResult");
            return (Criteria) this;
        }

        public Criteria andDealResultIn(List<String> values) {
            addCriterion("deal_result in", values, "dealResult");
            return (Criteria) this;
        }

        public Criteria andDealResultNotIn(List<String> values) {
            addCriterion("deal_result not in", values, "dealResult");
            return (Criteria) this;
        }

        public Criteria andDealResultBetween(String value1, String value2) {
            addCriterion("deal_result between", value1, value2, "dealResult");
            return (Criteria) this;
        }

        public Criteria andDealResultNotBetween(String value1, String value2) {
            addCriterion("deal_result not between", value1, value2, "dealResult");
            return (Criteria) this;
        }

        public Criteria andCommentIsNull() {
            addCriterion("comment is null");
            return (Criteria) this;
        }

        public Criteria andCommentIsNotNull() {
            addCriterion("comment is not null");
            return (Criteria) this;
        }

        public Criteria andCommentEqualTo(String value) {
            addCriterion("comment =", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentNotEqualTo(String value) {
            addCriterion("comment <>", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentGreaterThan(String value) {
            addCriterion("comment >", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentGreaterThanOrEqualTo(String value) {
            addCriterion("comment >=", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentLessThan(String value) {
            addCriterion("comment <", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentLessThanOrEqualTo(String value) {
            addCriterion("comment <=", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentLike(String value) {
            addCriterion("comment like", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentNotLike(String value) {
            addCriterion("comment not like", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentIn(List<String> values) {
            addCriterion("comment in", values, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentNotIn(List<String> values) {
            addCriterion("comment not in", values, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentBetween(String value1, String value2) {
            addCriterion("comment between", value1, value2, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentNotBetween(String value1, String value2) {
            addCriterion("comment not between", value1, value2, "comment");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}