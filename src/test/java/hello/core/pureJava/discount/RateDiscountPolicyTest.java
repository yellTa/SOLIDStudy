package hello.core.pureJava.discount;

import hello.core.pureJava.member.Grade;
import hello.core.pureJava.member.Member;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RateDiscountPolicyTest {

    RateDiscountPolicy discountPolicy = new RateDiscountPolicy();


    @Test
    @DisplayName("vip 10퍼 적용")
    void vip_o() {

        //givin
        Member member = new Member(1L, "memberA", Grade.VIP);
        //when
        int discount = discountPolicy.discount(member, 10000);

        //then
        assertThat(discount).isEqualTo(1000);

    }


    @Test
    @DisplayName("VIP가 아니면 할인이 적용되지 않아야 한다.")
    void vip_x() {
        //given
        Member member = new Member(2L, "memberBASIC", Grade.BASIC);
        //when
        int discount = discountPolicy.discount(member, 10000);
        //then
        assertThat(discount).isEqualTo(0);
    }
}