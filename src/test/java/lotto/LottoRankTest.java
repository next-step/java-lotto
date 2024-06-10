package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;


class LottoRankTest {
    @DisplayName("로또 당첨 금액 테스트")
    @ParameterizedTest(name = "{0}의 당첨 금액은 {1}원이다.")
    @CsvSource({
            "FIRST, 2000000000",
            "SECOND, 30000000",
            "THIRD, 1500000",
            "FOURTH, 50000",
            "FIFTH, 5000",
            "NONE, 0",
    })
    void price(LottoRank lottoRank, long expectedPrice) {
        assertThat(lottoRank.getPrice()).isEqualTo(expectedPrice);
    }
}