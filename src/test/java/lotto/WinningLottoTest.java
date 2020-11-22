package lotto;

import lotto.model.CandidateLotto;
import lotto.model.Hit;
import lotto.model.Lottoes;
import lotto.model.WinningLotto;
import lotto.strategy.ManualStrategy;
import org.junit.jupiter.api.Test;
import util.CommonUtils;

import java.util.Arrays;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningLottoTest {
    @Test
    public void 추첨_결과_테스트() {
        WinningLotto winnerNumbers = new WinningLotto(new ManualStrategy(CommonUtils.arrayTosotedSet(new int[]{1,2,3,4,5,6})));

        CandidateLotto testHit3 = new CandidateLotto(new ManualStrategy(CommonUtils.arrayTosotedSet(new int[]{1,2,3,45,35,36})));
        CandidateLotto testHit32 = new CandidateLotto(new ManualStrategy(CommonUtils.arrayTosotedSet(new int[]{1,2,3,45,35,36})));
        CandidateLotto testHit4 = new CandidateLotto(new ManualStrategy(CommonUtils.arrayTosotedSet(new int[]{1,2,3,4,35,36})));
        CandidateLotto testHit5 = new CandidateLotto(new ManualStrategy(CommonUtils.arrayTosotedSet(new int[]{1,2,3,4,5,36})));
        CandidateLotto testHit6 = new CandidateLotto(new ManualStrategy(CommonUtils.arrayTosotedSet(new int[]{1,2,3,4,5,6})));

        Lottoes lottoes = new Lottoes(CandidateLotto.PRICE * 5, Arrays.asList(testHit3, testHit32, testHit4, testHit5, testHit6));

        Map<Hit, Integer> result = winnerNumbers.getResult(lottoes.getLottoes());

        assertThat(result.get(Hit.HIT_3)).isEqualTo(2);
        assertThat(result.get(Hit.HIT_4)).isEqualTo(1);
        assertThat(result.get(Hit.HIT_5)).isEqualTo(1);
        assertThat(result.get(Hit.HIT_6)).isEqualTo(1);
    }

    @Test
    public void 수익률_테스트() {
        WinningLotto winnerNumbers = new WinningLotto(new ManualStrategy(CommonUtils.arrayTosotedSet(new int[]{1,2,3,4,5,6})));

        CandidateLotto testHit3 = new CandidateLotto(new ManualStrategy(CommonUtils.arrayTosotedSet(new int[]{1,2,3,45,35,36})));
        CandidateLotto testHitNone = new CandidateLotto(new ManualStrategy(CommonUtils.arrayTosotedSet(new int[]{21,22,23,24,35,36})));

        Lottoes lottoes = new Lottoes(14000, Arrays.asList(testHit3, testHitNone));

        double result = winnerNumbers.getEarningRate(14000, lottoes.getLottoes());

        assertThat(result).isEqualTo(0.35);
    }
}
