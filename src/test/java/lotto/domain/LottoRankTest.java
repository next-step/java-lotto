package lotto.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoRankTest {
    @ParameterizedTest
    @CsvSource(value = {
            "0, true, MISS",
            "1, false, MISS",
            "2, true, MISS",
            "3, false, FIFTH",
            "4, true, FOURTH",
            "5, false, THIRD",
            "5, true, SECOND",
            "6, false, FIRST",
            "6, true, FIRST"
    })
    void valueOfMatchCount_일치하는_숫자갯수로_등수판별(int count, boolean matchBonus, String lottoRankString) {
        assertThat(LottoRank.findLottoRank(count, matchBonus)).isEqualTo(LottoRank.valueOf(lottoRankString));
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 7})
    void valueOfMatchCount_잘못된_일치하는_숫자갯수(int count) {
        assertThatThrownBy(() -> LottoRank.findLottoRank(count, false)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "MISS, 10, 0",
            "FIFTH, 10, 50_000",
            "FOURTH, 10, 500_000",
            "THIRD, 10, 15_000_000",
            "SECOND, 10, 300_000_000",
            "FIRST, 1, 2_000_000_000"
    })
    void countWinningMoney_해당등수에_해당하는_로또갯수만큼의_금액(String lottoRankString, int matchLottoCount, int countWinningPrice) {
        assertThat(LottoRank.valueOf(lottoRankString).countWinningMoney(matchLottoCount)).isEqualTo(countWinningPrice);
    }

    @Test
    void countWinningMoney_일치하는_로또_갯수가_음수인_경우() {
        assertThatThrownBy(() -> LottoRank.FIFTH.countWinningMoney(-1)).isInstanceOf(IllegalArgumentException.class);
    }
}
