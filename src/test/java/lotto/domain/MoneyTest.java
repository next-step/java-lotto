package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class MoneyTest {

    @ParameterizedTest
    @DisplayName("돈으로 몇 개의 로또를 살 수 있는지 알려준다.")
    @CsvSource(value = {"3000, 3", "1000, 1"})
    void change_to_lotto_cnt(long given, long expected) {
        // given
        Money money = new Money();

        // when
        long result = money.lottoQuantity(given);

        // then
        assertThat(result).isEqualTo(expected);
    }
}
