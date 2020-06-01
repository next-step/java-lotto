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
}
