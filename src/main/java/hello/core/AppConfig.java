package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class AppConfig {

    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository()); // ctrl + alt + m (지포스와 안겹치는 지 확인)
    }

    private MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

     public DiscountPolicy discountPolicy() {
        return new FixDiscountPolicy();
     }

}
