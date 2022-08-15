package com.example.jesperreport.service.model;

import com.example.jesperreport.service.Utils;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class LendingFileForm {
    @JsonProperty("channelType")
    private String channelType;

    @JsonProperty("inputSource")
    private String inputSource;

    @JsonProperty("acuConsent")
    private String acuConsent;

    @JsonProperty("acuSource")
    private String acuSource;

    @JsonProperty("sellerName")
    private String sellerName;

    @JsonProperty("sellerId")
    private String sellerId;

    @JsonProperty("branch")
    private String branch;

    @JsonProperty("comId")
    private String comId;

    @JsonProperty("packageCode")
    private String packageCode;

    @JsonProperty("campaignCode")
    private String campaignCode;

    @JsonProperty("dseRefNo")
    private String dseRefNo;

    @JsonProperty("isPersonalCash")
    private boolean isPersonalCash;
    private String displayPersonalCashCheckBox;
    @JsonProperty("cashAmount")
    private double cashAmount;
    private final int MAX_CASH_AMOUNT = 17;
    private String displayCashAmount;

    @JsonProperty("debtDuration")
    private int debtDuration;

    @JsonProperty("clientNameTH")
    private String clientNameTH;

    @JsonProperty("clientNameEN")
    private String clientNameEN;

    @JsonProperty("cid")
    private String cid;

    @JsonProperty("cidExpire")
    private String cidExpire; //dd-mm-yyyy

    @JsonProperty("birthDate")
    private String birthDate; //dd-mm-yyyy

    @JsonProperty("nationality")
    private String nationality;

    @JsonProperty("relation")
    private String relation;

    @JsonProperty("education")
    private String education;

    @JsonProperty("address")
    private Address address;
    @JsonProperty("phone")
    private String phone;
    @JsonProperty("mobile")
    private String mobile;
    @JsonProperty("email")
    private String email;

    @JsonProperty("shippingAddress")
    private Address shippingAddress;

    public void setIsPersonalCash(boolean personalCash) {
        isPersonalCash = personalCash;
        checkDisplayPersonalCashCheckBox();
        System.out.println("setIsPersonalCash");
    }

    public boolean getIsPersonalCash() {
        return isPersonalCash;
    }

    public void setCashAmount(double cashAmount) {
        this.cashAmount = cashAmount;
        convertToCurrencyFormat();
        System.out.println("setCashAmount");
    }

    public void setPhone(String phone) {
        this.phone = Utils.handleEmptyField(phone);
    }

    public void setMobile(String mobile) {
        this.mobile = Utils.handleEmptyField(mobile);
    }

    public void setEmail(String email) {
        this.email = Utils.handleEmptyField(email);
    }

    public void checkDisplayPersonalCashCheckBox(){
        if(isPersonalCash){
            displayPersonalCashCheckBox = "&#9745;"; //checked
        }else{
            displayPersonalCashCheckBox = "&#9744;"; //unchecked
        }
    }

    public void convertToCurrencyFormat(){
        displayCashAmount = String.format("%,.0f", cashAmount);
        int count = MAX_CASH_AMOUNT-displayCashAmount.length();
        System.out.println(count);
        for(int i=0 ; i<count ; i++){
            displayCashAmount = displayCashAmount.concat("&nbsp;");
        }
        System.out.println(displayCashAmount);
    }
}
