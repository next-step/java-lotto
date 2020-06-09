package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class MoneyTest {

    @ParameterizedTest
    @CsvSource(value = {"1500,1", "4000,4"})
    @DisplayName("로또 몇장 살 수 있는지")
    void countLotto(int money, int expected) {
        int countLotto = new Money(money).countLotto();

        assertThat(countLotto).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"5000,250", "10000,500"})
    @DisplayName("수익률")
    void statistics(double sum, int expected) {
        Money money = new Money(2000);
        int result = (int) (money.statistics(sum) * 100);
        assertThat(result).isEqualTo(expected);
    }
}
