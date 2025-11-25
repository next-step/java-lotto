package lottoGame.model.lotto;

import static lottoGame.fixture.LottoFixture.로또번호리스트를_오름차순으로_생성한다;
import static lottoGame.fixture.LottoFixture.로또번호리스트를_지정해서_생성한다;
import static lottoGame.model.winner.WinStandard.FIRST;
import static lottoGame.model.winner.WinStandard.FIFTH;
import static lottoGame.model.winner.WinStandard.THIRD;
import static lottoGame.model.winner.WinStandard.SECOND;
import static lottoGame.model.winner.WinStandard.FOURTH;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lottoGame.model.winner.WinnerResult;
import org.junit.jupiter.api.Test;

class LottosTest {

    @Test
    void 발행된_로또들과_당첨번호를_비고해_당첨결과를_추출할_수_있다() {
        Lottos lottos = new Lottos(
                List.of(
                        new Lotto(로또번호리스트를_지정해서_생성한다(3, 9)),
                        new Lotto(로또번호리스트를_지정해서_생성한다(2, 8)),
                        new Lotto(로또번호리스트를_지정해서_생성한다(1, 7)),
                        new Lotto(로또번호리스트를_오름차순으로_생성한다(6))
                )
        );
        Lotto beforeWinLotto = new Lotto(로또번호리스트를_오름차순으로_생성한다(6));

        WinnerResult winnerResult = lottos.compareAndElectWinResult(beforeWinLotto, new LottoNum(45));

        assertThat(winnerResult.findWinCount(FIRST)).isEqualTo(1);
        assertThat(winnerResult.findWinCount(THIRD)).isEqualTo(1);
        assertThat(winnerResult.findWinCount(FOURTH)).isEqualTo(1);
        assertThat(winnerResult.findWinCount(FIFTH)).isEqualTo(1);
    }

    @Test
    void 발행된_로또들과_당첨번호를_비고해_2등_당첨결과를_추출할_수_있다() {
        Lottos lottos = new Lottos(
                List.of(
                        new Lotto(로또번호리스트를_지정해서_생성한다(1, 7))
                )
        );
        Lotto beforeWinLotto = new Lotto(로또번호리스트를_오름차순으로_생성한다(6));

        WinnerResult winnerResult = lottos.compareAndElectWinResult(
                beforeWinLotto,
                new LottoNum(7)
        );

        assertThat(winnerResult.findWinCount(SECOND)).isEqualTo(1);
    }

    @Test
    void 발행된_로또갯수를_확인할_수_있다() {
        Lottos lottos = new Lottos(
                List.of(new Lotto(로또번호리스트를_오름차순으로_생성한다(6)))
        );

        assertThat(lottos.size()).isEqualTo(1);
    }
}