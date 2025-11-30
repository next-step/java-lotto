package lottogame.model.lotto;

import static lottogame.fixture.LottoFixture.로또번호리스트를_오름차순으로_생성한다;
import static lottogame.fixture.LottoFixture.로또번호리스트를_지정해서_생성한다;
import static lottogame.model.lotto.LottoMachine.LOTTO_NUM_COUNT;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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

    @Test
    void 전달받은_로또와_객체의_로또를_비교해_같은번호의_갯수를_카운팅할_수_있다() {
        Lotto lotto = new Lotto(로또번호리스트를_오름차순으로_생성한다(6));
        Lotto winLotto = new Lotto(로또번호리스트를_지정해서_생성한다(2, 7));

        assertThat(
                winLotto.findMatchCountBy(lotto)
        ).isEqualTo(5);
    }


    @ParameterizedTest
    @CsvSource({"6, true", "7, false"})
    void 특정번호가_당첨번호에_포함되어있는지_확인할_수_있다(int num, boolean expect) {
        Lotto lotto = new Lotto(로또번호리스트를_오름차순으로_생성한다(6));

        assertThat(
                lotto.isContain(new LottoNum(num))
        ).isEqualTo(expect);
    }
}