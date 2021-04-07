package step4.domain.count;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step4.exception.InputNegativeAmountException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class PassiveCountTest {

    @DisplayName("PassiveCount 인스턴스 생성 여부 테스트")
    @Test
    void 생성() {
        // given
        int count = 0;

        // when
        PassiveCount passiveCount = PassiveCount.valueOf(count);

        // then
        assertThat(passiveCount).isNotNull();
    }

    @DisplayName("PassiveCount 인스턴스 음수 여부 테스트")
    @Test
    void 검증_음수() {
        // given
        int count = -1;

        // when
        assertThatThrownBy(()-> PassiveCount.valueOf(count))
                .isInstanceOf(InputNegativeAmountException.class)
                .hasMessageContaining("음수값이 입력되었습니다.");

    }

    @DisplayName("PassiveCount 인스턴스 음수 여부 테스트")
    @Test
    void 검증_반환() {
        // given
        int count = 3;

        // when


    }

}