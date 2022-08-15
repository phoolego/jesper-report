package com.example.jesperreport.service.model;

import com.example.jesperreport.service.Utils;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Address {
    @JsonProperty("addressNumber")
    private String addressNumber;
    @JsonProperty("roomNumber")
    private String roomNumber;
    @JsonProperty("building")
    private String building;
    @JsonProperty("floor")
    private String floor;
    @JsonProperty("mhu")
    private String mhu;
    @JsonProperty("soi")
    private String soi;
    @JsonProperty("road")
    private String road;
    @JsonProperty("subDistrict")
    private String subDistrict;
    @JsonProperty("district")
    private String district;
    @JsonProperty("province")
    private String province;
    @JsonProperty("zipCode")
    private String zipCode;

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = Utils.handleEmptyField(roomNumber);
    }

    public void setBuilding(String building) {
        this.building = Utils.handleEmptyField(building);
    }

    public void setFloor(String floor) {
        this.floor = Utils.handleEmptyField(floor);
    }

    public void setMhu(String mhu) {
        this.mhu = Utils.handleEmptyField(mhu);
    }

    public void setSoi(String soi) {
        this.soi = Utils.handleEmptyField(soi);
    }

}
