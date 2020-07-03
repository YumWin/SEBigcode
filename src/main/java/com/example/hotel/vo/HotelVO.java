package com.example.hotel.vo;

import com.example.hotel.enums.BizRegion;
import com.example.hotel.enums.HotelStar;
import com.example.hotel.po.HotelRoom;
import com.example.hotel.po.Order;
import com.example.hotel.po.User;

import java.util.ArrayList;
import java.util.List;

public class HotelVO {
    private Integer id;
    private String name;
    private String address;
    private String bizRegion;
    private String hotelStar;
    private Double rate;
    private String description;
    private String phoneNum;
    private Integer managerId;

    public List<Order> historyOrders = new ArrayList<>();

    //是否曾经预订过
    private boolean flag;

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    //商圈折扣
    private String businessDistrictDiscount;

    //vip等级
    private String VIPLevel;

    //vip等级折扣
    private String VIPLevelDiscount;

    public String getBusinessDistrictDiscount() {
        return businessDistrictDiscount;
    }

    public void setBusinessDistrictDiscount(String businessDistrictDiscount) {
        this.businessDistrictDiscount = businessDistrictDiscount;
    }

    public String getVIPLevel() {
        return VIPLevel;
    }

    public void setVIPLevel(String VIPLevel) {
        this.VIPLevel = VIPLevel;
    }

    public String getVIPLevelDiscount() {
        return VIPLevelDiscount;
    }

    public void setVIPLevelDiscount(String VIPLevelDiscount) {
        this.VIPLevelDiscount = VIPLevelDiscount;
    }

    private List<RoomVO> rooms;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBizRegion() {
        return bizRegion;
    }

    public void setBizRegion(String bizRegion) {
        this.bizRegion = bizRegion;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public String getHotelStar() {
        return hotelStar;
    }

    public void setHotelStar(String hotelStar) {
        this.hotelStar = hotelStar;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public List<RoomVO> getRooms() {
        return rooms;
    }

    public void setRooms(List<RoomVO> rooms) {
        this.rooms = rooms;
    }

    public Integer getManagerId() {
        return managerId;
    }

    public void setManagerId(Integer managerId) {
        this.managerId = managerId;
    }
}
