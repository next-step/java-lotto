package lotto;

import lotto.domain.Money;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class MoneyTest {

    @Test
    @DisplayName("정상적인 입력시 머니 객체가 정상적으로 생성된다.")
    void create() {
        int money = 14000;

        Assertions.assertThatNoException()
                .isThrownBy(() -> new Money(money));
    }

    @ParameterizedTest
    @ValueSource(ints={-14000, 999})
    @DisplayName("로또 구매 불가 금액 입력시 생성자가 예외를 던진다.")
    void validateNegative(int notValidMoney) {
        Assertions.assertThatThrownBy(() -> new Money(notValidMoney))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("금액에 맞는 로또 개수를 반환한다.")
    void countLotto() {
        Money money = new Money(1234);
        Assertions.assertThat(money.countLotto()).isEqualTo(1);
    }

    @Test
    @DisplayName("수익률을 계산하여 리턴한다.")
    void profitRate() {
        Money money = new Money(14000);
        Assertions.assertThat(money.profitRate(5000)).isEqualTo((double) 5000 / 14000);
    }
}
