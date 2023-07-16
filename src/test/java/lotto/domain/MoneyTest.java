package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class MoneyTest {

    @Test
    @DisplayName("정상적인 입력시 머니 객체가 정상적으로 생성된다.")
    void create() {
        int money = 14000;

        Assertions.assertThatNoException()
                .isThrownBy(() -> new Money(money));
    }

    @Test
    @DisplayName("음수 입력시 생성자가 예외를 던진다.")
    void validateNegative() {
        int negativeMoney = -14000;

        Assertions.assertThatThrownBy(() -> new Money(negativeMoney))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("천 단위가 아닌 값을 입력시 생성자가 예외를 던진다.")
    void validateThousand() {
        int notThousandMoney = 14500;

        Assertions.assertThatThrownBy(() -> new Money(notThousandMoney))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource({"2000, 2", "1000, 1"})
    @DisplayName("금액에 맞는 로또 개수를 반환한다.")
    void countLotto(long amount, long count) {
        Money money = new Money(amount);
        Assertions.assertThat(money.countLotto()).isEqualTo(count);
    }

    @Test
    @DisplayName("수익률을 계산하여 리턴한다.")
    void profitRate() {
        Money money = new Money(14000);
        Assertions.assertThat(money.findProfitRate(new Money(5000))).isEqualTo(new ProfitRate((double) 5000 / 14000));
    }
}
