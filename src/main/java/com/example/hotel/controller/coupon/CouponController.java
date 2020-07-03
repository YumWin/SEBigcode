package com.example.hotel.controller.coupon;

import com.example.hotel.bl.coupon.CouponService;
import com.example.hotel.po.Coupon;
import com.example.hotel.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/coupon")
public class CouponController {

    @Autowired
    private CouponService couponService;

    @PostMapping("/deleteCoupon")
    public ResponseVO deleteCoupon(@RequestParam Integer hotelId,@RequestParam Integer couponId){
        return ResponseVO.buildSuccess(couponService.deleteCoupon(hotelId,couponId));
    }

    @PostMapping("/hotelTargetMoney")
    public ResponseVO addHotelTargetMoneyCoupon(@RequestBody HotelTargetMoneyCouponVO hotelTargetMoneyCouponVO) {

        CouponVO couponVO = couponService.addHotelTargetMoneyCoupon(hotelTargetMoneyCouponVO);

        return ResponseVO.buildSuccess(couponVO);
    }

    @PostMapping("/hotelTargetRoom")
    public ResponseVO addHotelTargetRoomCoupon(@RequestBody HotelTargetRoomCouponVO hotelTargetRoomCouponVO){

        CouponVO couponVO = couponService.addHotelTargetRoomCoupon(hotelTargetRoomCouponVO);

        return ResponseVO.buildSuccess(couponVO);
    }

    @PostMapping("/hotelTimeCoupon")
    public ResponseVO addHotelTimeCoupon(@RequestBody TimeCouponVO hotelTimeCouponVO){

        CouponVO couponVO = couponService.addHotelTimeCoupon(hotelTimeCouponVO);

        return ResponseVO.buildSuccess(couponVO);
    }

    @PostMapping("/hotelCoopEnterpriseCoupon")
    public ResponseVO addCoopEnterpriseCoupon(@RequestBody CoopEnterpriseCouponVO coopEnterpriseCouponVO){

        CouponVO couponVO = couponService.addCoopEnterpriseCoupon(coopEnterpriseCouponVO);

        return ResponseVO.buildSuccess(couponVO);
    }

    @PostMapping("/hotelBirthdayCoupon")
    public ResponseVO addBirthdayCoupon(@RequestBody BirthdayCouponVO birthdayCouponVO){

        CouponVO couponVO = couponService.addBirthdayCoupon(birthdayCouponVO);

        return ResponseVO.buildSuccess(couponVO);
    }

    @PostMapping("/hotelVipCoupon")
    public ResponseVO addVipCoupon(@RequestBody VipCouponVO vipCouponVO){
        CouponVO couponVO = couponService.addVipCoupon(vipCouponVO);
        return ResponseVO.buildSuccess(couponVO);
    }

    @GetMapping("/hotelAllCoupons")
    public ResponseVO getHotelAllCoupons(@RequestParam Integer hotelId) {
        return ResponseVO.buildSuccess(couponService.getHotelAllCoupon(hotelId));
    }

    @GetMapping("/websiteAllCoupons")
    public ResponseVO getWebsiteAllCoupons(){
        return ResponseVO.buildSuccess(couponService.getWebsiteAllCoupon());
    }

    @GetMapping("/orderMatchCoupons")
    public ResponseVO getOrderMatchCoupons(@RequestParam Integer userId,
                                           @RequestParam Integer hotelId,
                                           @RequestParam Double orderPrice,
                                           @RequestParam Integer roomNum,
                                           @RequestParam String checkIn,
                                           @RequestParam String checkOut) {
        OrderVO requestOrderVO = new OrderVO();
        requestOrderVO.setUserId(userId);
        requestOrderVO.setHotelId(hotelId);
        requestOrderVO.setPrice(orderPrice);
        requestOrderVO.setRoomNum(roomNum);
        requestOrderVO.setCheckInDate(checkIn);
        requestOrderVO.setCheckOutDate(checkOut);
        return ResponseVO.buildSuccess(couponService.getMatchOrderCoupon(requestOrderVO));
    }


}
