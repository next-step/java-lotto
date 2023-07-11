package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class MoneyTest {

    @Test
    @DisplayName("정상적인 입력시 머니 객체 정상 생성")
    void create() {
        int money = 14000;

        Assertions.assertThatNoException()
                .isThrownBy(() -> new Money(money));
    }

    @Test
    @DisplayName("음수 입력시 예외 처리")
    void validateNegative() {
        int negativeMoney = -14000;

        Assertions.assertThatThrownBy(() -> new Money(negativeMoney))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource({"1234, 1", "999, 0"})
    @DisplayName("금액에 맞는 로또 개수 테스트")
    void countLotto(long amount, long count) {
        Money money = new Money(amount);
        Assertions.assertThat(money.countLotto()).isEqualTo(count);
    }
}
