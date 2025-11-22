package lottoGame.model.lotto;

import static lottoGame.fixture.LottoFixture.당첨번호리스트를_오름차순으로_생성한다;
import static lottoGame.fixture.LottoFixture.로또번호리스트를_오름차순으로_생성한다;
import static lottoGame.model.lotto.Lotto.LOTTO_NUM_COUNT;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lottoGame.model.winner.BeforeWinNums;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottoTest {

    @Test
    void 로또생성시_로또번호리스트의_갯수가_정해진값과_다르면_예외처리_할_수_있다() {
        assertThatThrownBy(() ->
                new Lotto(
                        로또번호리스트를_오름차순으로_생성한다(LOTTO_NUM_COUNT + 1)
                )
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource({"6, true", "7, false"})
    void 입력받은_당첨번호목록과_로또번호가_몇개나_같은지_비교할_수_있다() {
        Lotto lotto = new Lotto(로또번호리스트를_오름차순으로_생성한다(6));
        BeforeWinNums beforeWinNums = 당첨번호리스트를_오름차순으로_생성한다(6);

        assertThat(
                lotto.compareWith(beforeWinNums)
        ).isEqualTo(6);
    }
}