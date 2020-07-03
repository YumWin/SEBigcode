package com.example.hotel.controller.order;

import com.example.hotel.bl.order.OrderService;
import com.example.hotel.vo.OrderVO;
import com.example.hotel.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: chenyizong
 * @Date: 2020-02-29
 */


@RestController()
@RequestMapping("/api/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/addOrder")
    public ResponseVO reserveHotel(@RequestBody OrderVO orderVO){
        return orderService.addOrder(orderVO);
    }

    @GetMapping("/getAllOrders")
    public ResponseVO retrieveAllOrders(){

        return ResponseVO.buildSuccess(orderService.getAllOrders());
    }

    @GetMapping("/{userid}/getUserOrders")
    public  ResponseVO retrieveUserOrders(@PathVariable int userid){
        return ResponseVO.buildSuccess(orderService.getUserOrders(userid));
    }

    @GetMapping("/{orderid}/annulOrder")
    public ResponseVO annulOrder(@PathVariable int orderid){
        return orderService.annulOrder(orderid);
    }

    @PostMapping("/changeOrderState")
    public ResponseVO changeOrderState(@RequestParam("orderState") String orderState,@RequestParam("orderId") Integer orderid){
        return orderService.changeOrderState(orderid,orderState);}

    @PostMapping("/deleteOrder")
    public ResponseVO deleteOrder(@RequestParam("orderId") Integer orderid){return orderService.deleteOrder(orderid);}

    @GetMapping("/{hotelId}/allOrders")
    public ResponseVO retrieveHotelOrders(@PathVariable Integer hotelId) {
        return ResponseVO.buildSuccess(orderService.getHotelOrders(hotelId));
    }

    //
    @GetMapping("/all")
    public ResponseVO retrieveAllHotels(){

        return ResponseVO.buildSuccess(orderService.retrieveHotels());
    }

    //
    @GetMapping("/{hotelId}/detail")
    public ResponseVO retrieveHotelDetail(@PathVariable Integer hotelId) {
        return ResponseVO.buildSuccess(orderService.retrieveHotelDetails(hotelId));
    }

    @GetMapping("/orderStateJudge")
    public ResponseVO orderStateJudge(){
        this.orderService.judge();
        //System.out.println("isJudged");
        return ResponseVO.buildSuccess("isJudged");
    }
}
