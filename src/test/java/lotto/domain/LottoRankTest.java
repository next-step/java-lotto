package lotto.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class LottoRankTest {
    @ParameterizedTest
    @CsvSource(value = {
            "0, MISS",
            "1, MISS",
            "2, MISS",
            "3, FOURTH",
            "4, THIRD",
            "5, SECOND",
            "6, FIRST"
    })
    void valueOfMatchCount_일치하는_숫자갯수로_등수판별(int count, String lottoRankString) {
        assertThat(LottoRank.valueOfMatchCount(count)).isEqualTo(LottoRank.valueOf(lottoRankString));
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 7})
    void valueOfMatchCount_잘못된_일치하는_숫자갯수(int count) {
        assertThatThrownBy(() -> LottoRank.valueOfMatchCount(count)).isInstanceOf(IllegalArgumentException.class);
    }
}
