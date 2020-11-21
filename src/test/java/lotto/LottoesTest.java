package lotto;

import lotto.model.CandidateLotto;
import lotto.model.Lottoes;
import lotto.strategy.ManualStrategy;
import org.junit.jupiter.api.Test;
import util.CommonUtils;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoesTest {
    @Test
    public void 가진_금액_보다_구입_개수가_많은_경우() {

        CandidateLotto test1 = new CandidateLotto(new ManualStrategy(CommonUtils.arrayToset(new int[]{1,2,3,4,5,6})));
        CandidateLotto test2 = new CandidateLotto(new ManualStrategy(CommonUtils.arrayToset(new int[]{1,2,3,4,5,6})));
        assertThatIllegalArgumentException().isThrownBy(() -> new Lottoes(100, Arrays.asList(test1, test2)));
    }

    @Test
    public void 정상_수동_구입() {
        CandidateLotto test1 = new CandidateLotto(new ManualStrategy(CommonUtils.arrayToset(new int[]{1,2,3,4,5,6})));
        CandidateLotto test2 = new CandidateLotto(new ManualStrategy(CommonUtils.arrayToset(new int[]{1,2,3,4,5,6})));
        Lottoes lottoes = new Lottoes(CandidateLotto.PRICE * 2, Arrays.asList(test1, test2));
        assertThat(lottoes.getLottoCount()).isEqualTo(2);
    }

}
