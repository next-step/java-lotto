package lotto;

import lotto.model.Hit;
import lotto.model.lotto.*;
import lotto.strategy.ManualStrategy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.TestUtils;

import java.util.Collections;
import java.util.List;
import java.util.SortedSet;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoesTest {
    private SortedSet<LottoNumber> baseNumbers;
    private WinningLotto winningLotto;

    @BeforeEach
    void init(){
        baseNumbers = TestUtils.arrayToSortedSet(new int[]{1, 2, 3, 4, 5, 6});
        winningLotto = new WinningLotto(LottoNumber.of(7), new ManualStrategy(baseNumbers));
    }

    @Test
    public void 수동_정상_구입() {

        List<String> testCase = Collections.singletonList("1, 2, 3, 4, 5, 6");

        Lottoes lottoes = new Lottoes(0, testCase);
        assertThat(lottoes.size()).isEqualTo(1);
        assertThat(winningLotto.matches(lottoes).get(Hit.HIT_6)).isEqualTo(1);
    }

    @Test
    public void 자동_정상_구입() {
        Lottoes lottoes = new Lottoes(5 * Lotto.PRICE, Collections.emptyList());
        assertThat(lottoes.size()).isEqualTo(5);
    }

    @Test
    public void 수동_자동_정상_구입() {
        List<String> testCase = Collections.singletonList("1, 2, 3, 4, 5, 6");
        Lottoes lottoes = new Lottoes(5 * Lotto.PRICE, testCase);

        assertThat(lottoes.size()).isEqualTo(6);
    }
}
