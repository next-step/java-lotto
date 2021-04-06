package step4.domain.money;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step4.exception.InputNegativeAmountException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class MoneyTest {

    @DisplayName("Money 인스턴스 생성 여부 테스트")
    @Test
    void 생성() {
        // given
        int value = 1;

        // when
        Money money = Money.valueOf(value);

        // then
        assertThat(money).isNotNull();
    }

    @DisplayName("Money 인스턴스에 음수 입력시 예외처리 여부 테스트")
    @Test
    void 검증_음수() {
        // given
        int value = -1;

        // when
        assertThatThrownBy(()-> Money.valueOf(value))
                .isInstanceOf(InputNegativeAmountException.class)
                .hasMessageContaining("음수값이 입력되었습니다.");
    }


}