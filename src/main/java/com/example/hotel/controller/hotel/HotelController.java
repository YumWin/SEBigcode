package com.example.hotel.controller.hotel;

import com.example.hotel.bl.hotel.HotelService;
import com.example.hotel.bl.hotel.RoomService;
import com.example.hotel.bl.order.OrderService;
import com.example.hotel.po.HotelRoom;
import com.example.hotel.util.ServiceException;
import com.example.hotel.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/hotel")
public class HotelController {

    @Autowired
    private HotelService hotelService;
    @Autowired
    private RoomService roomService;
//    @Autowired
//    private OrderService orderService;
//

    @PostMapping("/addHotel")
    public ResponseVO createHotel(@RequestBody HotelVO hotelVO) throws ServiceException {
        //TODO 添加酒店的后端逻辑完善
        //System.out.println(hotelVO.getName());
        hotelService.addHotel(hotelVO);
        return ResponseVO.buildSuccess(true);
    }

    @PostMapping("/all")
    public ResponseVO detailedSearchHotel(@RequestBody SearchInfVO searchInfVO) throws ServiceException {
        System.out.println(searchInfVO);
        return ResponseVO.buildSuccess(hotelService.detailedSearchHotel(searchInfVO));
    }

    @PostMapping("/updateHotelInfo")
    public ResponseVO updateHotelInfo(@RequestBody HotelVO hotelVO) throws ServiceException{
        hotelService.updateHotelInfo(hotelVO);
        return ResponseVO.buildSuccess(true);
    }

    @PostMapping("/modifyRoomInfo")
    public ResponseVO modifyRoomInfo(@RequestBody RoomVO roomVO) throws ServiceException{
        roomService.modifyRoomInfo(roomVO);
        return ResponseVO.buildSuccess(true);
    }

    @PostMapping("/modifyVIPRules")
    public ResponseVO modifyVIPRules(@RequestBody VipInfoVO vipInfoVO)throws ServiceException{
        hotelService.modifyVIPRules(vipInfoVO);
        return ResponseVO.buildSuccess(true);
    }

    @GetMapping("/getVIPRules")
    public ResponseVO getVIPRules()throws ServiceException{
        return ResponseVO.buildSuccess(hotelService.getVIPRules());
    }

    @GetMapping("/address")
    public ResponseVO searchHotel(@RequestParam("address") String address,@RequestParam("bizRegion") String bizRegion) throws ServiceException {
        return ResponseVO.buildSuccess(hotelService.searchHotel(address,bizRegion));
    }

    @GetMapping("/rateSort")
    public ResponseVO rateSortHotel() throws ServiceException{
        return ResponseVO.buildSuccess(hotelService.rateSortHotel());
    }

    @GetMapping("/priceSort")
    public ResponseVO priceSortHotel(@RequestParam("priceSortJudge") boolean priceSortJudge) throws ServiceException{
        return ResponseVO.buildSuccess(hotelService.priceSortHotel(priceSortJudge));
    }

    @PostMapping("/roomInfo")
    public ResponseVO addRoomInfo(@RequestBody HotelRoom hotelRoom) {
        roomService.insertRoomInfo(hotelRoom);
        return ResponseVO.buildSuccess(true);
    }

    @PostMapping("/deleteHotel")
    public ResponseVO deleteHotel(@RequestParam("hotelId") Integer hotelId) throws ServiceException {
        hotelService.deleteHotel(hotelId);
        return ResponseVO.buildSuccess(true);
    }

    @PostMapping("/addComment")
    public ResponseVO addComment(@RequestBody CommentVO commentVO) {
        hotelService.addComments(commentVO);
        return ResponseVO.buildSuccess(true);
    }
    @GetMapping("/{hotelId}/comments")
    public ResponseVO getComments(@PathVariable Integer hotelId)  throws ServiceException{
        System.out.println("hotelId"+hotelId);
       return ResponseVO.buildSuccess(hotelService.getComments(hotelId));
    }
//    @PostMapping("/updateCommentLike")
//    public ResponseVO updateCommentLike(@RequestParam("commentId") Integer commentId,@RequestParam("like") Integer like) {
//        hotelService.updateCommentLike(commentId,like);
//        return ResponseVO.buildSuccess(true);
//    }
//    @PostMapping("/updateCommentDislike")
//    public ResponseVO updateCommentDislike(@RequestParam("commentId") Integer commentId,@RequestParam("dislike") Integer dislike) {
//        hotelService.updateCommentDislike(commentId,dislike);
//        return ResponseVO.buildSuccess(true);
//    }


}
