package lotto.domain;

import lotto.domain.exception.InvalidLottoNumberException;
import lotto.domain.exception.InvalidLottoParsingNumberException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class LottoNumberTest {
    @Test
    void 로또_숫자_객체를_생성할_수_있다() {
        assertThat(new LottoNumber(5).getNumber()).isEqualTo(5);
    }

    @Test
    void 문자열로_로또_숫자_객체를_생성할_수_있다() {
        assertThat(LottoNumber.from("31").getNumber()).isEqualTo(31);
    }

    @ParameterizedTest(name = "{0}은 로또 숫자의 범위를 벗어나서 예외가 발생한다")
    @ValueSource(ints = {0, 46, -2})
    void 로또_숫자의_범위가_1에서_45_사이가_아니면_오류가_발생한다(int input) {
        assertThatThrownBy(() -> new LottoNumber(input))
                .isInstanceOf(InvalidLottoNumberException.class);
    }

    @ParameterizedTest(name = "{0} 입력은 숫자가 아닌 문자이므로 예외가 발생한다.")
    @ValueSource(strings = {"a", "가", "%", "1a"})
    void 숫자가_아닌_문자열로_로또를_만들면_예외가_발생한다(String input) {
        assertThatThrownBy(() -> LottoNumber.from(input))
                .isInstanceOf(InvalidLottoParsingNumberException.class);
    }

    @Test
    void 동일한_로또_숫자를_가지면_동일한_객체이다() {
        assertThat(new LottoNumber(3)).isEqualTo(new LottoNumber(3));
    }

    @Test
    void 로또_숫자_객체와_int형_데이터를_비교할_수_있다() {
        assertThat(new LottoNumber(5)).isEqualTo(5);
    }
}
