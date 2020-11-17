package lotto.domain.lotto;

import lotto.domain.rank.Rank;
import lotto.domain.rank.LottoRankCalculator;
import org.junit.jupiter.api.Test;
import lotto.dto.WinLotteryResult;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottosTest {
    @Test
    void of_return_empty_obj_when_receive_null() {
        // when
        final Lottos result = Lottos.of(null);
        
        // then
        assertThat(result).isEqualTo(Lottos.EMPTY);
    }
    
    @Test
    void size() {
        // given
        final List<Lotto> lottoList = LottoMockFactory.createFourTeenLotto();
        final Lottos lottos = Lottos.of(lottoList);

        // when
        final int result = lottos.size();

        // then
        assertThat(result).isEqualTo(lottoList.size());
    }


    @Test
    void countHitNumber() {
        // given
        final Lottos lottos = Lottos.of(LottoMockFactory.createFourTeenLotto());
        final Lotto winningLottery = Lotto.of(
                Arrays.asList(
                        LottoNumber.of(1),
                        LottoNumber.of(2),
                        LottoNumber.of(3),
                        LottoNumber.of(4),
                        LottoNumber.of(5),
                        LottoNumber.of(6)
                ),
                LottoNumber.MAX
        );
        final LottoRankCalculator lottoRankCalculator = new LottoRankCalculator();
        
        // when
        final WinLotteryResult result = lottoRankCalculator.calculate(lottos, winningLottery);

        // then
        assertAll(
                () -> assertThat(result.getFirstRank().getCount()).isEqualTo(0),
                () -> assertThat(result.getSecondRank().getCount()).isEqualTo(0),
                () -> assertThat(result.getThirdRank().getCount()).isEqualTo(0),
                () -> assertThat(result.getFourthRank().getCount()).isEqualTo(0),
                () -> assertThat(result.getFifthRank().getCount()).isEqualTo(1),
                () -> assertThat(result.getTotalPrizeMoney()).isEqualTo(Rank.FIFTH.getWinningMoney())
        );
    }
}