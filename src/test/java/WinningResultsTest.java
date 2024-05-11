import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningResultsTest {
    @Test
    public void 구매한_로또와_당첨번호를_비교해_당첨등수를_반환한다() {
        LottoNumbers buyLottoNumbers = new LottoNumbers(1, 2, 3, 10, 11, 12);
        Lottos buyLottos = new Lottos(new Lotto(buyLottoNumbers));

        LottoNumbers winningLottoNumbers = new LottoNumbers(1, 2, 3, 4, 5, 6);

        WinningResults winningResults = buyLottos.draw(buyLottos, winningLottoNumbers);
        assertThat(winningResults.countByRank(Rank.FIFTH)).isEqualTo(1);
    }

    @Test
    public void 수익률_구입_금액_대비_당첨금을_계산한다() {
        LottoNumbers buyLottoNumbers = new LottoNumbers(1, 2, 3, 10, 11, 12);
        Lottos buyLottos = new Lottos(new Lotto(buyLottoNumbers));

        LottoNumbers winningLottoNumbers = new LottoNumbers(1, 2, 3, 4, 5, 6);

        WinningResults winningResults = buyLottos.draw(buyLottos, winningLottoNumbers);
        assertThat(winningResults.winningRate()).isEqualTo(1);
    }
}
