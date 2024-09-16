package hello.core.pureJava;

import hello.core.pureJava.discount.DiscountPolicy;
import hello.core.pureJava.discount.FixDiscountPolicy;
import hello.core.pureJava.member.MemberRepository;
import hello.core.pureJava.member.MemberService;
import hello.core.pureJava.member.MemberServiceImpl;
import hello.core.pureJava.member.MemoryMemberRepository;
import hello.core.pureJava.order.OrderService;
import hello.core.pureJava.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


//appliction환경 구성은 여기서 다 하는 거임

@Configuration //Spring 옵션
public class Appconfig {
    //역할들이 나오고 역할들이 어떤 구현체를 갖는 지 확인할 수 있다.
    //역할과 구현 클래스가 한눈에 들어온다.


    //bean을 쓰면 Spring Container에 저장이 된다.
    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(
                memberRepository(), discountPolicy());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        return new FixDiscountPolicy();
    }

}
