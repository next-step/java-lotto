package step3.domain.money;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.exception.InputNegativeAmountException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class MoneyTest {

    @DisplayName("Money 인스턴스 생성 여부 테스트")
    @Test
    void 생성() {
        // given
        int amount = 1000;

        // when
        Money money = Money.valueOf(amount);

        // then
        assertThat(money).isNotNull();
    }

    @DisplayName("Money 인스턴스 음수 입력시 예외처리 여부 테스트")
    @Test
    void 검증_음수() {
        // given
        int amount = -1;

        // when and then
        assertThatThrownBy(() -> Money.valueOf(amount))
                .isInstanceOf(InputNegativeAmountException.class)
                .hasMessageContaining("음수값의 돈이 입력되었습니다.");

    }
}