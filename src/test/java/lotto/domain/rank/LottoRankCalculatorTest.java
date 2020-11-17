package lotto.domain.rank;

import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.Lottos;
import lotto.dto.WinLotteryResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collections;

import static lotto.domain.lotto.LottoMockFactory.createLottoHasNumberOneToSix;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoRankCalculatorTest {

    @DisplayName("로또 번호를 모두 맞춘 경우")
    @Test
    void calculateWinLotteryResult_when_hit_all_lotto_number() {
        // given
        final LottoRankCalculator calculator = new LottoRankCalculator();
        final Lottos lottos = Lottos.of(Collections.singletonList(createLottoHasNumberOneToSix()));
        final Lotto winningLottery = createLottoHasNumberOneToSix();

        // when
        final WinLotteryResult result = calculator.calculateWinLotteryResult(lottos, winningLottery);

        // then
        assertAll(
                () -> assertThat(result.getFirstRank().getCount()).isOne(),
                () -> assertThat(result.getSecondRank().getCount()).isZero(),
                () -> assertThat(result.getThirdRank().getCount()).isZero(),
                () -> assertThat(result.getFourthRank().getCount()).isZero(),
                () -> assertThat(result.getTotalPrizeMoney()).isEqualTo(Rank.FIRST.getWinningMoney())
        );
    }

}