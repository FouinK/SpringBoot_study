package springBasic.core.discount;

import org.springframework.stereotype.Component;
import springBasic.core.member.Grade;
import springBasic.core.member.Member;

@Component
public class RateDiscountPolicy implements DiscountPolicy {

    private int discountPolicy = 10;

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            return price * discountPolicy/100;
        } else {
            return 0;
        }
    }
}
