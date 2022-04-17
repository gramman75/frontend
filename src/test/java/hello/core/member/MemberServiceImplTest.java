package hello.core.member;

import hello.core.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MemberServiceImplTest {

    MemberService memberService;

    @BeforeEach
    void beforEach(){
        AppConfig appConfig = new AppConfig();
        this.memberService = appConfig.memberService();
    }

    @Test
    void join() {
        Member member = new Member(1L,"name", Grade.BASIC);

        memberService.join(member);
        Member findMember = memberService.findMember(1L);

        Assertions.assertThat(member).isEqualTo(findMember);
    }

}