package lotto;

import lotto.domain.LottoResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static lotto.domain.LottoRank.ETC;
import static lotto.domain.LottoRank.FIRST;
import static lotto.domain.LottoRank.FOURTH;
import static lotto.domain.LottoRank.SECOND;
import static lotto.domain.LottoRank.THIRD;
import static org.assertj.core.api.Assertions.assertThat;

class LottoResultTest {
    @DisplayName("로또 결과 총 당첨금, 수익률 테스트")
    @Test
    public void lottoResult() {
        LottoResult lottoResult = new LottoResult(Map.of(FIRST, 1, SECOND, 2, THIRD, 3, FOURTH, 4, ETC, 6));
        assertThat(lottoResult.totalWinnings())
                .isEqualTo(2064700000L);

        assertThat(lottoResult.rateOfReturn())
                .isEqualTo(129043.75);
    }
}