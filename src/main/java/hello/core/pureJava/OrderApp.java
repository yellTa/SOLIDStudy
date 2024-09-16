package hello.core.pureJava;

import hello.core.pureJava.member.Grade;
import hello.core.pureJava.member.Member;
import hello.core.pureJava.member.MemberService;
import hello.core.pureJava.order.Order;
import hello.core.pureJava.order.OrderService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderApp {
    public static void main(String[] args) {
        // AppConfig appConfig = new AppConfig(); // MemberService memberService = appConfig.memberService(); // OrderService orderService = appConfig.orderService();
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Appconfig.class);
        MemberService memberService =
                applicationContext.getBean("memberService", MemberService.class);
        OrderService orderService = applicationContext.getBean("orderService", OrderService.class);

        long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);
        Order order = orderService.createOrder(memberId, "itemA", 10000);
        System.out.println("order = " + order);
    }
}
