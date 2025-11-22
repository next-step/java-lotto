package lottoGame.model.lotto;

import static lottoGame.fixture.LottoFixture.로또번호리스트를_오름차순으로_생성한다;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lottoGame.fixture.LottoFixture;
import lottoGame.model.winner.BeforeWinNums;
import lottoGame.model.winner.WinnerResult;
import org.junit.jupiter.api.Test;

class LottosTest {

    @Test
    void 발행된_로또들과_당첨번호를_비고해_당첨결과를_추출할_수_있다() {
//        Lottos lottos = new Lottos(로또번호리스트를_오름차순으로_생성한다());
//        BeforeWinNums beforeWinNums = new BeforeWinNums();

//        WinnerResult winnerResult = lottos.compareAndElectWinResult(beforeWinNums);


    }

    @Test
    void 발행된_로또갯수를_확인할_수_있다() {
        Lottos lottos = new Lottos(
                List.of(new Lotto(로또번호리스트를_오름차순으로_생성한다(6)))
        );

        assertThat(lottos.size()).isEqualTo(6);
    }
}