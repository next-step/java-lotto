package lottogame.model.lotto;

import static lottogame.fixture.LottoFixture.로또번호리스트를_오름차순으로_생성한다;
import static lottogame.fixture.LottoFixture.로또번호리스트를_지정해서_생성한다;
import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

import lottogame.model.winner.Rank;
import org.junit.jupiter.api.Test;

class WinningLottoNumsTest {

    @Test
    void 입력받은_당첨번호목록과_로또번호가_1등인지_비교할_수_있다() {
        WinningLottoNums winningLottoNums = new WinningLottoNums(
                new Lotto(로또번호리스트를_오름차순으로_생성한다(6)),
                LottoNum.of(7)
        );
        Lotto lotto = new Lotto(로또번호리스트를_오름차순으로_생성한다(6));

        assertThat(
                winningLottoNums.checkIfWin(lotto)
        ).isEqualTo(Rank.FIRST);
    }

    @Test
    void 입력받은_당첨번호목록과_로또번호가_꽝인지_비교할_수_있다() {
        WinningLottoNums winningLottoNums = new WinningLottoNums(
                new Lotto(로또번호리스트를_지정해서_생성한다(6, 11)),
                LottoNum.of(45)
        );

        Lotto lotto = new Lotto(로또번호리스트를_오름차순으로_생성한다(6));

        assertThat(
                winningLottoNums.checkIfWin(lotto)
        ).isEqualTo(Rank.NOTHING);
    }

    @Test
    void 입력받은_당첨번호목록과_보너스볼이_2등인지_비교할_수_있다() {
        WinningLottoNums winningLottoNums = new WinningLottoNums(
                new Lotto(로또번호리스트를_지정해서_생성한다(2, 7)),
                LottoNum.of(1)
        );
        Lotto lotto = new Lotto(로또번호리스트를_오름차순으로_생성한다(6));

        assertThat(
                winningLottoNums.checkIfWin(lotto)
        ).isEqualTo(Rank.SECOND);
    }

    @Test
    void 입력받은_당첨번호목록에_보너스볼이_존재하면_예외처리_할_수_있다() {
        assertThatThrownBy(
                 () -> new WinningLottoNums(new Lotto(로또번호리스트를_지정해서_생성한다(2, 7)), LottoNum.of(3))
        ).isInstanceOf(IllegalArgumentException.class);
    }
}