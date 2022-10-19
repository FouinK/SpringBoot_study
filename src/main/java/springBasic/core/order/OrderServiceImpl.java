package springBasic.core.order;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import springBasic.core.annotation.MainDiscountPolicy;
import springBasic.core.discount.DiscountPolicy;
import springBasic.core.discount.FixDiscountPolicy;
import springBasic.core.member.Member;
import springBasic.core.member.MemberRepository;
import springBasic.core.member.MemoryMemberRepository;

@Component
//@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    @Autowired //->생성자 주입은 없어도 알아서 자동으로 달아줌
    public OrderServiceImpl(MemberRepository memberRepository,@MainDiscountPolicy/*@Qualifier("mainDiscountPolicy")*/ DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    //테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
