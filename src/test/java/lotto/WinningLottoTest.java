package lotto;

import lotto.model.CandidateLotto;
import lotto.model.Hit;
import lotto.model.Lottoes;
import lotto.model.WinningLotto;
import lotto.strategy.ManualStrategy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import util.CommonUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningLottoTest {
    private int[] winningNumbers;

    @BeforeEach
    void init() {
        winningNumbers = new int[]{1,2,3,4,5,6};
    }

    @Test
    public void 추첨_결과_테스트() {

        WinningLotto winnerNumbers = makeWinningLotto(7);

        CandidateLotto testHit3 = makeCandidateLotto(new int[]{1,2,3,45,35,36});
        CandidateLotto testHit32 = makeCandidateLotto(new int[]{1,2,3,45,35,36});
        CandidateLotto testHit4 = makeCandidateLotto(new int[]{1,2,3,4,35,36});
        CandidateLotto testHit5 = makeCandidateLotto(new int[]{1,2,3,4,5,36});
        CandidateLotto testHit6Bonus = makeCandidateLotto(new int[]{1,2,3,4,5,7});
        CandidateLotto testHit6 = makeCandidateLotto(new int[]{1,2,3,4,5,6});

        List<CandidateLotto> testCase = Arrays.asList(testHit3, testHit32, testHit4, testHit5, testHit6Bonus, testHit6);
        Lottoes lottoes = new Lottoes(CandidateLotto.PRICE * 6, testCase);

        Map<Hit, Integer> result = winnerNumbers.getResult(lottoes.getLottoes());

        assertThat(result.get(Hit.HIT_3)).isEqualTo(2);
        assertThat(result.get(Hit.HIT_4)).isEqualTo(1);
        assertThat(result.get(Hit.HIT_5)).isEqualTo(1);
        assertThat(result.get(Hit.HIT_6_BONUS)).isEqualTo(1);
        assertThat(result.get(Hit.HIT_6)).isEqualTo(1);
    }

    @Test
    public void 수익률_테스트() {
        WinningLotto winnerNumbers = makeWinningLotto(0);

        CandidateLotto testHit3 = makeCandidateLotto(new int[]{1,2,3,45,35,36});
        CandidateLotto testHitNone = makeCandidateLotto(new int[]{21,22,23,24,35,36});

        Lottoes lottoes = new Lottoes(14000, Arrays.asList(testHit3, testHitNone));

        double result = winnerNumbers.getEarningRate(14000, lottoes.getLottoes());

        assertThat(result).isEqualTo(0.35);
    }

    private CandidateLotto makeCandidateLotto(int[] numbers) {
        return new CandidateLotto(new ManualStrategy(CommonUtils.arrayToSortedSet(numbers)));
    }

    private WinningLotto makeWinningLotto(int bonus) {
        return new WinningLotto(bonus, new ManualStrategy(CommonUtils.arrayToSortedSet(winningNumbers)));
    }
}
