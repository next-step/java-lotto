package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class LottosTest {
    private final List<LottoNumber> lottoNumbers1 = IntStream.rangeClosed(1, 6).mapToObj(index -> new LottoNumber(index)).collect(Collectors.toList());

    @Test
    public void 로또_결과를_추가할_수_있다() {
        Lottos lottos = new Lottos();
        Lotto lotto = new Lotto(lottoNumbers1);

        lottos.addLotto(lotto);

        assertThat(lottos.size()).isEqualTo(1);
        assertThat(lottos.getLottos()).contains(lotto);
    }

    @Test
    public void 당첨번호에_따라_로또_결과를_계산할_수_있다() {
        Lottos lottos = new Lottos();
        Lotto lotto1 = new Lotto(lottoNumbers1);
        WinningNumber winningNumber = new WinningNumber(lottoNumbers1);

        lottos.addLotto(lotto1);
        lottos.calculateLotto(winningNumber);

        assertThat(lottos.getCountByMatchCount(6)).isEqualTo(1);
    }

    @Test
    public void 특정_매치_수에_대한_상금을_조회할_수_있다() {
        Lottos lottos = new Lottos();
        Lotto lotto = new Lotto(lottoNumbers1);
        lottos.addLotto(lotto);

        WinningNumber winningNumber = new WinningNumber(lottoNumbers1);

        lottos.calculateLotto(winningNumber);

        int prizeMoney = lottos.getPrizeMoneyByMatchCount(6);

        assertThat(prizeMoney).isEqualTo(2000000000);
    }

    @Test
    public void 특정_매치_수에_대한_수익을_계산할_수_있다() {
        Lottos lottos = new Lottos();
        Lotto lotto = new Lotto(lottoNumbers1);
        lottos.addLotto(lotto);

        WinningNumber winningNumber = new WinningNumber(lottoNumbers1);
        lottos.calculateLotto(winningNumber);

        int prizeMoney = lottos.getEarningsByMatchCount(6);

        assertThat(prizeMoney).isEqualTo(lottos.getPrizeMoneyByMatchCount(6));
    }
}
