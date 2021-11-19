package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class LottoRankTest {

    @ParameterizedTest
    @CsvSource(value = {"6,2000000000", "5,1500000", "4,50000", "3,5000"})
    @DisplayName("로또 당첨금 확인 테스트")
    void lottoAmount(int matchCount, int amount) {
        assertThat(LottoRank.valueOf(matchCount).getAmount()).isEqualTo(amount);
    }
}