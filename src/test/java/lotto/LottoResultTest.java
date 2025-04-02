package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static lotto.LottoRank.ETC;
import static lotto.LottoRank.FIRST;
import static lotto.LottoRank.FOURTH;
import static lotto.LottoRank.SECOND;
import static lotto.LottoRank.THIRD;
import static org.assertj.core.api.Assertions.assertThat;

class LottoResultTest {
    @DisplayName("로또 결과 테스트")
    @Test
    public void lottoResult() {
        LottoResult lottoResult = new LottoResult(Map.of(FIRST, 1, SECOND, 2, THIRD, 3, FOURTH, 4, ETC, 9));
        assertThat(lottoResult.totalWinnings())
                .isEqualTo(2003170000L);

        assertThat(lottoResult.rateOfReturn())
                .isEqualTo(105430.0);
    }
}