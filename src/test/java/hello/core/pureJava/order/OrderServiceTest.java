package hello.core.pureJava.order;

import hello.core.pureJava.Appconfig;
import hello.core.pureJava.member.Grade;
import hello.core.pureJava.member.Member;
import hello.core.pureJava.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {

    MemberService memberService;
    OrderService orderService;
    @BeforeEach
    public void beforeEach(){
        Appconfig app = new Appconfig();
        memberService = app.memberService();
        orderService = app.orderService();
    }

    @Test
    void createOrder(){
        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);

        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);

    }


}
