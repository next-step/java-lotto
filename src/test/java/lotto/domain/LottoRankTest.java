package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottoRankTest {

    @ParameterizedTest
    @CsvSource(value = {"FIRST:false", "SECOND:false", "BONUS:true"}, delimiter = ':')
    void 맞춘갯수를_당첨등수로_변환(LottoRank lottoRank, boolean matchBonus) {
        WinningResult winningResult = new WinningResult(lottoRank.getCorrectCount(), matchBonus);
        assertThat(LottoRank.findRank(winningResult)).isEqualTo(lottoRank);
    }

    @Test
    void 보너스_등수_맞추기() {
        WinningResult winningResult = new WinningResult(5, true);

        assertThat(LottoRank.findRank(winningResult)).isEqualTo(LottoRank.BONUS);
    }

    @Test
    void 이등_맞추기() {
        WinningResult winningResult = new WinningResult(5, false);
        assertThat(LottoRank.findRank(winningResult)).isEqualTo(LottoRank.SECOND);
    }

}