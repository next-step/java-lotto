package lotto;

import lotto.model.*;
import lotto.model.lotto.*;
import lotto.strategy.ManualStrategy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.TestUtils;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class WinningLottoTest {
    private int[] winningNumbers;

    @BeforeEach
    void init() {
        winningNumbers = new int[]{1,2,3,4,5,6};
    }

    @Test
    public void 당첨_번호_안에_보너스_볼이_들어간_경우(){
        assertThatIllegalArgumentException()
                .isThrownBy(() -> makeWinningLotto(6))
                .withMessageMatching("당첨 번호에는 보너스 볼 번호가 들어갈 수 없습니다.");
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

        CandidateLotto testBonus = makeCandidateLotto(new int[]{11,12,13,14,15,7});

        List<CandidateLotto> testCase = Arrays.asList(testHit3, testHit32, testHit4, testHit5, testHit6Bonus, testHit6, testBonus);

        Lottoes lottoes = new Lottoes(0, Optional.of(testCase));

        Map<Hit, Integer> result = winnerNumbers.matches(lottoes);

        assertThat(result.get(Hit.HIT_3)).isEqualTo(2);
        assertThat(result.get(Hit.HIT_4)).isEqualTo(1);
        assertThat(result.get(Hit.HIT_6_BONUS)).isEqualTo(1);
        assertThat(result.get(Hit.HIT_5)).isEqualTo(1);
        assertThat(result.get(Hit.HIT_6)).isEqualTo(1);
    }

    @Test
    public void 수익률_테스트() {
        WinningLotto winnerNumbers = makeWinningLotto(13);

        CandidateLotto testHit3 = makeCandidateLotto(new int[]{1,2,3,45,35,36});
        CandidateLotto testHitNone = makeCandidateLotto(new int[]{21,22,23,24,35,36});

        Lottoes lottoes = new Lottoes(0, Optional.of(Arrays.asList(testHit3, testHitNone)));
        LottoPrice lottoPrice = new LottoPrice(14000, "0");

        double result = winnerNumbers.earningRate(lottoes,lottoPrice);

        assertThat(result).isEqualTo(0.35);
    }

    private CandidateLotto makeCandidateLotto(int[] inputNumbers) {
        SortedSet<LottoNumber> lottoTicket = TestUtils.arrayToSortedSet(inputNumbers);
        return new CandidateLotto(new ManualStrategy(lottoTicket));
    }

    private WinningLotto makeWinningLotto(int bonus) {
        SortedSet<LottoNumber> lottoTicket = TestUtils.arrayToSortedSet(winningNumbers);
        return new WinningLotto(LottoNumber.of(bonus), new ManualStrategy(lottoTicket));
    }
}
