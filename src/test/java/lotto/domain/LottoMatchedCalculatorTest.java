package lotto.domain;

import lotto.data.LottoWinInfo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static lotto.util.ConstUtils.*;
import static org.assertj.core.api.Assertions.assertThat;

class LottoMatchedCalculatorTest {

    @DisplayName("매치된 번호의 카운트가 증가한다.")
    @Test
    void saveMatched() {
        // given
        LottoMatchedCalculator lottoMatchedCalculator = new LottoMatchedCalculator();

        // when
        lottoMatchedCalculator.saveMatched(3);

        // then
        assertThat(lottoMatchedCalculator.countMatchedThree()).isEqualTo(1);
    }

    @DisplayName("수익률을 계산한다. (당첨금액/구매지불금액)")
    @Test
    void earnRate() {
        // given
        LottoMatchedCalculator lottoMatchedCalculator = new LottoMatchedCalculator();

        // when
        lottoMatchedCalculator.saveMatched(3);
        lottoMatchedCalculator.saveMatched(4);
        lottoMatchedCalculator.saveMatched(4);
        lottoMatchedCalculator.saveMatched(5);

        int winningResult = LottoWinInfo.WIN_FOURTH.getWinningPrice() +
                (LottoWinInfo.WIN_THIRD.getWinningPrice() * 2) +
                LottoWinInfo.WIN_SECOND.getWinningPrice();
        int purchasedMoney = 4 * LOTTO_WON_UNIT;

        // then
        assertThat(lottoMatchedCalculator.earnRate(purchasedMoney)).isEqualTo((double) winningResult / purchasedMoney);
    }
}
