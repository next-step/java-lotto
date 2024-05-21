import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningResultsTest {
    @Test
    public void 구매한_로또와_당첨번호를_비교해_당첨등수를_반환한다() {
        List<Integer> buyLottoNumbers = Arrays.asList(1, 2, 3, 10, 11, 12);
        Lottos buyLottos = new Lottos(new Lotto(buyLottoNumbers));
        LottoNumber bonusNumber = LottoNumber.of(20);

        Lotto winningLotto = new Lotto(1, 2, 3, 4, 5, 6);

        WinningResults winningResults = buyLottos.draw(winningLotto, bonusNumber);
        assertThat(winningResults.countByRank(Rank.FIFTH)).isEqualTo(1);
    }

    @Test
    public void 수익률_구입_금액_대비_당첨금을_계산한다() {
        List<Integer> buyLottoNumbers = Arrays.asList(1, 2, 3, 10, 11, 12);
        Lottos buyLottos = new Lottos(new Lotto(buyLottoNumbers));
        LottoNumber bonusNumber = LottoNumber.of(20);

        Lotto winningLotto = new Lotto(1, 2, 3, 4, 5, 6);

        WinningResults winningResults = buyLottos.draw(winningLotto, bonusNumber);
        assertThat(winningResults.winningRate()).isEqualTo(1);
    }

    @Test
    public void 당첨개수가_5개이고_보너스번호가_일치하지않으면_3등이다() {
        List<Integer> buyLottoNumbers = Arrays.asList(1, 2, 3, 4, 5, 12);
        Lottos buyLottos = new Lottos(new Lotto(buyLottoNumbers));

        Lotto winningLotto = new Lotto(1, 2, 3, 4, 5, 6);
        LottoNumber bonusNumber = LottoNumber.of(20);

        WinningResults winningResults = buyLottos.draw(winningLotto, bonusNumber);
        assertThat(winningResults.countByRank(Rank.THIRD)).isEqualTo(1);
    }


    @Test
    public void 당첨개수가_5개이고_보너스번호가_일치하면_2등이다() {
        List<Integer> buyLottoNumbers = Arrays.asList(1, 2, 3, 4, 5, 12);
        Lottos buyLottos = new Lottos(new Lotto(buyLottoNumbers));

        Lotto winningLotto = new Lotto(1, 2, 3, 4, 5, 6);
        LottoNumber bonusNumber = LottoNumber.of(12);

        WinningResults winningResults = buyLottos.draw(winningLotto, bonusNumber);
        assertThat(winningResults.countByRank(Rank.SECOND)).isEqualTo(1);
    }
}
