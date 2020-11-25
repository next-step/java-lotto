package lotto;

import lotto.model.CandidateLotto;
import lotto.model.lotto.LottoNumber;
import lotto.model.lotto.LottoTicket;
import lotto.model.lotto.Lottoes;
import lotto.strategy.ManualStrategy;
import org.junit.jupiter.api.Test;
import utils.TestUtils;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoesTest {
    @Test
    public void 수동_정상_구입() {
        LottoTicket lottoTicket = new LottoTicket(TestUtils.arrayToSortedSet(new int[]{1, 2, 3, 4, 5, 6}));
        CandidateLotto test = new CandidateLotto(new ManualStrategy(lottoTicket));
        List<CandidateLotto> testCase = Collections.singletonList(test);

        Lottoes lottoes = new Lottoes(0, Optional.of(testCase));
        assertThat(lottoes.getLottoes().size()).isEqualTo(1);
        assertThat(lottoes.getLottoes().get(0).getNumbers()).containsExactly(
                new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5),
                new LottoNumber(6)
        );
    }

    @Test
    public void 자동_정상_구입() {
        Lottoes lottoes = new Lottoes(5, Optional.empty());
        assertThat(lottoes.getLottoes().size()).isEqualTo(5);
    }

    @Test
    public void 수동_자동_정상_구입() {
        LottoTicket lottoTicket = new LottoTicket(TestUtils.arrayToSortedSet(new int[]{1, 2, 3, 4, 5, 6}));
        CandidateLotto test = new CandidateLotto(new ManualStrategy(lottoTicket));
        List<CandidateLotto> testCase = Collections.singletonList(test);

        Lottoes lottoes = new Lottoes(5, Optional.of(testCase));
        assertThat(lottoes.getLottoes().size()).isEqualTo(6);
        assertThat(lottoes.getLottoes().get(0).getNumbers()).containsExactly(
                new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5),
                new LottoNumber(6)
        );
    }
}
