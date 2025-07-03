package ex.dddstudy.domain;

import lombok.Getter;
import org.springframework.util.Assert;

import java.util.Objects;

import static ex.dddstudy.domain.MemberStatus.ACTIVE;
import static ex.dddstudy.domain.MemberStatus.PENDING;
import static org.springframework.util.Assert.state;

@Getter
public class Member {

    private String email;
    private String nickName;
    private String passwordHash;
    private MemberStatus status;

    public Member(String email, String nickName, String passwordHash) {
        this.email = Objects.requireNonNull(email);
        this.nickName = Objects.requireNonNull(nickName);
        this.passwordHash = Objects.requireNonNull(passwordHash);
        this.status = PENDING;
    }

    public void activate() {
        state(status == PENDING, "PENDING 상태가 아닙니다");
        this.status = MemberStatus.ACTIVE;
    }

    public void deactivate() {
        state(status == ACTIVE, "ACTIVE 상태가 아닙니다");
        this.status = MemberStatus.DEACTIVATED;
    }
}
