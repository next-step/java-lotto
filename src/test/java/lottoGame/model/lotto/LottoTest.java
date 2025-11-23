package lottoGame.model.lotto;

import static lottoGame.fixture.LottoFixture.당첨번호리스트를_오름차순으로_생성한다;
import static lottoGame.fixture.LottoFixture.당첨번호리스트를_지정해서_생성한다;
import static lottoGame.fixture.LottoFixture.로또번호리스트를_오름차순으로_생성한다;
import static lottoGame.model.lotto.Lotto.LOTTO_NUM_COUNT;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lottoGame.model.winner.BeforeWinNums;
import lottoGame.model.winner.WinStandard;
import org.junit.jupiter.api.Test;

class LottoTest {

    @Test
    void 로또생성시_로또번호리스트의_갯수가_정해진값과_다르면_예외처리_할_수_있다() {
        assertThatThrownBy(() ->
                new Lotto(
                        로또번호리스트를_오름차순으로_생성한다(LOTTO_NUM_COUNT + 1)
                )
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 입력받은_당첨번호목록과_로또번호가_1등인지_비교할_수_있다() {
        Lotto lotto = new Lotto(로또번호리스트를_오름차순으로_생성한다(6));
        BeforeWinNums beforeWinNums = 당첨번호리스트를_오름차순으로_생성한다(6);

        assertThat(
                lotto.checkIfWin(beforeWinNums)
        ).isEqualTo(WinStandard.FIRST);
    }

    @Test
    void 입력받은_당첨번호목록과_로또번호가_꽝인지_비교할_수_있다() {
        Lotto lotto = new Lotto(로또번호리스트를_오름차순으로_생성한다(6));
        BeforeWinNums beforeWinNums = 당첨번호리스트를_지정해서_생성한다(5, 11);

        assertThat(
                lotto.checkIfWin(beforeWinNums)
        ).isEqualTo(WinStandard.NOTHING);
    }

}