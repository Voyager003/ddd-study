package ex.dddstudy.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MemberTest {

    @Test
    @DisplayName("멤버 생성 테스트")
    void createMember() {
        /*
         * given :
         * when :
         * then :
         */
        var member = new Member("aa@gogole.app", "rome", "secret");

        assertThat(member.getStatus()).isEqualTo(MemberStatus.PENDING);
    }

    @Test
    @DisplayName("생성자 null 테스트")
    void constructorNullCheck() {
        /*
         * given :
         * when :
         * then :
         */
        assertThatThrownBy(() -> new Member(null, "rome", "secret"))
                .isInstanceOf(NullPointerException.class);
    }

    @Test
    @DisplayName("멤버 활성화 테스트")
    void checkActivate() {
        /**
         * given :
         * when :
         * then :
         */
        var member= new Member("aa@gogole.app", "rome", "secret");

        member.activate();

        assertThat(member.getStatus()).isEqualTo(MemberStatus.ACTIVE);
    }

    @Test
    @DisplayName("활성화 된 멤버가 가입을 시도하는 경우")
    void memberActiveTest() {
        /**
         * given :
         * when :
         * then :
         */

        var member= new Member("aa@gogole.app", "rome", "secret");

        member.activate();

        assertThatThrownBy(member::activate)
                .isInstanceOf(IllegalStateException.class);

    }

    @Test
    @DisplayName("회원 탈퇴 기능 테스트")
    void deactivateFail() {
        /*
         * given :
         * when :
         * then :
         */
        var member= new Member("aa@gogole.app", "rome", "secret");
        member.activate();

        member.deactivate();

        assertThat(member.getStatus()).isEqualTo(MemberStatus.DEACTIVATED);
    }
}