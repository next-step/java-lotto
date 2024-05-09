import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class DrawTest {
    @Test
    public void 구매한_로또와_당첨번호를_비교해_일치한_개수별통계를_낸다() {
        LottoNumbers buyLottoNumbers = LottoNumbers.of(1, 2, 3, 10, 11, 12);
        Lottos buyLottos = new Lottos(new Lotto(buyLottoNumbers));

        LottoNumbers winningLottoNumbers = LottoNumbers.of(1, 2, 3, 4, 5, 6);

        WinningResults winningResults = LottoDraw.draw(buyLottos, winningLottoNumbers);
        assertThat(winningResults.countByRank(Rank.FIFTH)).isEqualTo(1);
    }

    @Test
    public void 수익률_구입_금액_대비_당첨금을_계산한다() {
        LottoNumbers buyLottoNumbers = LottoNumbers.of(1, 2, 3, 10, 11, 12);
        Lottos buyLottos = new Lottos(new Lotto(buyLottoNumbers));

        LottoNumbers winningLottoNumbers = LottoNumbers.of(1, 2, 3, 4, 5, 6);

        WinningResults winningResults = LottoDraw.draw(buyLottos, winningLottoNumbers);
        assertThat(winningResults.winningRate()).isEqualTo(1);
    }
}
