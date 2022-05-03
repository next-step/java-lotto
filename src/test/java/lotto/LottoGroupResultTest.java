package lotto;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class LottoGroupResultTest {
    @Test
    void getEarningRatio_총수익률_계산() {
        LottoGroupResult lottoGroupResult = new LottoGroupResult(Map.of(
                Rank.FOURTH, 1
        ));
        assertThat(lottoGroupResult.getEarningRatio(14000)).isEqualTo(0.35);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "FIRST, 3",
            "SECOND, 2"
    })
    void getLottoMatchCount_해당등수의_로또_카운트(String rankString, int count) {
        Rank rank = Rank.valueOf(rankString);
        LottoGroupResult lottoGroupResult = new LottoGroupResult(Map.of(
                rank, count
        ));
        assertThat(lottoGroupResult.getLottoMatchCount(rank)).isEqualTo(count);
    }
}