package step2;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottosTest {
    
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
        final Lotto answer = Lotto.of(
                Arrays.asList(
                        LottoNumber.of(1),
                        LottoNumber.of(2),
                        LottoNumber.of(3),
                        LottoNumber.of(4),
                        LottoNumber.of(5),
                        LottoNumber.of(6)
                )
        );
        // when
        final WinLotteryResult result = lottos.countHitNumber(answer);
        
        // then
        assertAll(
                () -> assertThat(result.getHitThreeTimes().getCount()).isEqualTo(1),
                () -> assertThat(result.getHitFourTimes().getCount()).isEqualTo(0),
                () -> assertThat(result.getHitFiveTimes().getCount()).isEqualTo(0),
                () -> assertThat(result.getHitSixTimes().getCount()).isEqualTo(0),
                () -> assertThat(result.getTotalPrizeMoney()).isEqualTo(Reward.HIT_THREE_TIMES.getMoney())
        );
    }
    

}