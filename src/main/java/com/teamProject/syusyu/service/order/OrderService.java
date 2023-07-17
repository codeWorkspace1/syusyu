package com.teamProject.syusyu.service.order;

import com.teamProject.syusyu.domain.member.CouponDTO;
import com.teamProject.syusyu.domain.order.Order;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.SessionAttribute;

import java.util.List;
import java.util.Map;

public interface OrderService {
    Map<String, Object> orderSheet(int[] cartProdNoArr, int mbrId) throws Exception;

    @Transactional(rollbackFor = Exception.class)
    void order(Order order) throws Exception;

    List<CouponDTO> getOrderCouponList(@SessionAttribute int mbrId, @RequestBody int totProductPrice) throws Exception;
}
