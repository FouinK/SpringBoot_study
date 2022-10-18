package springBasic.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springBasic.core.discount.DiscountPolicy;
import springBasic.core.discount.RateDiscountPolicy;
import springBasic.core.member.MemberRepository;
import springBasic.core.member.MemberService;
import springBasic.core.member.MemberServiceImpl;
import springBasic.core.member.MemoryMemberRepository;
import springBasic.core.order.OrderService;
import springBasic.core.order.OrderServiceImpl;

@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }


}
