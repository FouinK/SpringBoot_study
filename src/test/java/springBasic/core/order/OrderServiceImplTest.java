package springBasic.core.order;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import springBasic.core.AppConfig;
import springBasic.core.member.Grade;
import springBasic.core.member.Member;
import springBasic.core.member.MemberService;

import static org.junit.jupiter.api.Assertions.*;

class OrderServiceImplTest {

    MemberService memberService;
    OrderService orderService;

    @BeforeEach
    public void beforeEach() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
        orderService = appConfig.orderService();
    }


    @Test
    void createOrder() {
        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Order book = orderService.createOrder(member.getId(), "book", 10000);

        Assertions.assertEquals(book.getDiscountPrice(), 1000);

    }
}