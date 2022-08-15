package com.example.jesperreport.service;

public class Utils {
    public static String handleEmptyField(String field){
        if(field==null || field.isEmpty()){
            return "-";
        } else{
            return field;
        }
    }
}
