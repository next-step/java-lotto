package lottogame.model.lotto;

import static lottogame.fixture.LottoFixture.로또번호리스트를_오름차순으로_생성한다;
import static lottogame.fixture.LottoFixture.로또번호리스트를_지정해서_생성한다;
import static lottogame.model.winner.WinStandard.FIRST;
import static lottogame.model.winner.WinStandard.FIFTH;
import static lottogame.model.winner.WinStandard.THIRD;
import static lottogame.model.winner.WinStandard.SECOND;
import static lottogame.model.winner.WinStandard.FOURTH;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lottogame.model.winner.WinnerResult;
import org.junit.jupiter.api.Test;

class LottosTest {

    @Test
    void 발행된_로또들과_당첨번호를_비고해_당첨결과를_추출할_수_있다() {
        Lottos lottos = new Lottos(
                List.of(
                        new Lotto(로또번호리스트를_지정해서_생성한다(4, 9)),
                        new Lotto(로또번호리스트를_지정해서_생성한다(3, 8)),
                        new Lotto(로또번호리스트를_지정해서_생성한다(2, 7)),
                        new Lotto(로또번호리스트를_오름차순으로_생성한다(6))
                )
        );
        Lotto winLotto = new Lotto(로또번호리스트를_오름차순으로_생성한다(6));
        WinningLottoNums winningLottoNums = new WinningLottoNums(winLotto, LottoNum.getInstance(45));

        WinnerResult winnerResult = lottos.compareAndElectWinResult(winningLottoNums);

        assertThat(winnerResult.findWinCount(FIRST)).isEqualTo(1);
        assertThat(winnerResult.findWinCount(THIRD)).isEqualTo(1);
        assertThat(winnerResult.findWinCount(FOURTH)).isEqualTo(1);
        assertThat(winnerResult.findWinCount(FIFTH)).isEqualTo(1);
    }

    @Test
    void 발행된_로또들과_당첨번호를_비고해_2등_당첨결과를_추출할_수_있다() {
        Lottos lottos = new Lottos(
                List.of(
                        new Lotto(로또번호리스트를_지정해서_생성한다(2, 7))
                )
        );
        WinningLottoNums winningLottoNums = new WinningLottoNums(
                new Lotto(로또번호리스트를_오름차순으로_생성한다(6)),
                LottoNum.getInstance(7)
        );

        WinnerResult winnerResult = lottos.compareAndElectWinResult(winningLottoNums);

        assertThat(winnerResult.findWinCount(SECOND)).isEqualTo(1);
    }

    @Test
    void 발행된_로또갯수를_확인할_수_있다() {
        Lottos lottos = new Lottos(
                List.of(new Lotto(로또번호리스트를_오름차순으로_생성한다(6)))
        );

        assertThat(lottos.size()).isEqualTo(1);
    }

    // TODO 사실 이렇게 단순히 사이즈만 테스트 할 수 밖에 없는 상황에서 살짝 불안감을 느낍니다. 이 테스트가 과연 충분할까? 거짓 양성을 심어놓는거 아닐까? 같은 생각들이요.
    //  아래 같은 상황은 merge라는 구현방법 자체를 다시 생각해봐야하는 신호일까요?
    @Test
    void 두개의_로또목록을_병합할_수_있다() {
        Lottos baseLottos = new Lottos(
                List.of(new Lotto(로또번호리스트를_오름차순으로_생성한다(6)))
        );
        Lottos additionalLottos = new Lottos(
                List.of(new Lotto(로또번호리스트를_지정해서_생성한다(7, 12)))
        );

        Lottos mergedLottos = baseLottos.merge(additionalLottos);

        assertThat(mergedLottos.size()).isEqualTo(2);
    }

}