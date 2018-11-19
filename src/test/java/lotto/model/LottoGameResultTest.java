package lotto.model;

import lotto.enums.LottoReword;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoGameResultTest {

    LottoGameResult lottoGameResult;
    Money money;
    Lotto lotto;
    WinningLotto winningLotto;

    @Before
    public void setup() {
        lottoGameResult = new LottoGameResult();
        money = new Money(2000);

        Set<Integer> numbers = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 7));
        Set<Integer> winnerNumbers = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 21));
        int bonusNumber = 7;

        lotto = Lotto.from(numbers);
        winningLotto = WinningLotto.from(winnerNumbers, LottoNo.from(bonusNumber));

    }

    @Test
    public void setRewordCount() {
        lottoGameResult.setRewordCount(lotto, winningLotto);

        Map<LottoReword, Integer> results = lottoGameResult.getResults();

        assertThat(results.get(LottoReword.FIVE_AND_BONUS_MATCH)).isEqualTo(1);
    }

    @Test
    public void earningsRate() {
        lottoGameResult.setRewordCount(lotto, winningLotto);

        float earningsRate = lottoGameResult.earningsRate(money);

        assertThat(earningsRate).isEqualTo(15000.0f);
    }
}