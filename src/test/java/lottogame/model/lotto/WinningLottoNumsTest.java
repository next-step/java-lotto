package lottogame.model.lotto;

import static lottogame.fixture.LottoFixture.로또번호리스트를_오름차순으로_생성한다;
import static lottogame.fixture.LottoFixture.로또번호리스트를_지정해서_생성한다;
import static org.assertj.core.api.Assertions.assertThat;

import lottogame.model.winner.WinStandard;
import org.junit.jupiter.api.Test;

class WinningLottoNumsTest {

    @Test
    void 입력받은_당첨번호목록과_로또번호가_1등인지_비교할_수_있다() {
        WinningLottoNums winningLottoNums = new WinningLottoNums(
                new Lotto(로또번호리스트를_오름차순으로_생성한다(6)),
                new LottoNum(7)
        );
        Lotto lotto = new Lotto(로또번호리스트를_오름차순으로_생성한다(6));

        assertThat(
                winningLottoNums.checkIfWin(lotto)
        ).isEqualTo(WinStandard.FIRST);
    }

    @Test
    void 입력받은_당첨번호목록과_로또번호가_꽝인지_비교할_수_있다() {
        WinningLottoNums winningLottoNums = new WinningLottoNums(
                new Lotto(로또번호리스트를_지정해서_생성한다(5, 11)),
                new LottoNum(7)
        );

        Lotto lotto = new Lotto(로또번호리스트를_오름차순으로_생성한다(6));

        assertThat(
                winningLottoNums.checkIfWin(lotto)
        ).isEqualTo(WinStandard.NOTHING);
    }

    @Test
    void 입력받은_당첨번호목록과_보너스볼이_2등인지_비교할_수_있다() {
        WinningLottoNums winningLottoNums = new WinningLottoNums(
                new Lotto(로또번호리스트를_지정해서_생성한다(1, 7)),
                new LottoNum(1)
        );
        Lotto lotto = new Lotto(로또번호리스트를_오름차순으로_생성한다(6));

        assertThat(
                winningLottoNums.checkIfWin(lotto)
        ).isEqualTo(WinStandard.SECOND);
    }
}