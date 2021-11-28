package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import lotto.exception.ManualCountException;
import lotto.exception.MinimumAmountException;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class MoneyTest {

    @ParameterizedTest
    @CsvSource(value = {"10000:3", "14000:3", "1000:1"}, delimiter = ':')
    void create(int purchaseAmount, int manualCount) {
        assertThat(Money.of(purchaseAmount, manualCount)).isInstanceOf(Money.class);
    }

    @ParameterizedTest
    @CsvSource(value = {"10000:11", "14000:15", "1000:2"}, delimiter = ':')
    void manualCountOverException(int purchaseAmount, int manualCount) {
        assertThatExceptionOfType(ManualCountException.class)
            .isThrownBy(() -> Money.of(purchaseAmount, manualCount));
    }

    @ParameterizedTest
    @CsvSource(value = {"900:11", "0:15", "100:2"}, delimiter = ':')
    void minimumAmountException(int purchaseAmount, int manualCount) {
        assertThatExceptionOfType(MinimumAmountException.class)
            .isThrownBy(() -> Money.of(purchaseAmount, manualCount));
    }

}
