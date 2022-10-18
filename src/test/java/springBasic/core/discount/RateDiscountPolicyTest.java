package springBasic.core.discount;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import springBasic.core.AppConfig;
import springBasic.core.member.*;
import springBasic.core.order.Order;
import springBasic.core.order.OrderService;

import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {
    MemberService memberService;
    OrderService orderService;

    @BeforeEach
    public void beforeEach() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
        orderService = appConfig.orderService();
    }

    @Test
    @DisplayName("VIP 할인은 10% 할인이 적용되어야 함.")
    void discount() {
        //given
        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        //when
        Order item = orderService.createOrder(member.getId(), "itemA", 12000);

        //then
        System.out.println("item = " + item);

    }
}