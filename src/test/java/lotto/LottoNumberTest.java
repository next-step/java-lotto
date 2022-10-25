package lotto;

import lotto.domain.LottoNumber;
import lotto.domain.RandomNumberGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoNumberTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6})
    void 로또_숫자는_입력한만큼_생성된다(int source) {
        LottoNumber lottoNumber = new LottoNumber(source, new RandomNumberGenerator(1, 45));
        assertThat(lottoNumber.getNumbers()).hasSize(source);
    }

    @ParameterizedTest
    @CsvSource(value = {"'1, 2, 3', 3"})
    void 로또_숫자는_문자열로도_생성된다(String source, int expected) {
        assertThat(new LottoNumber(source).getNumbers()).hasSize(expected);
    }

    @Test
    void 빈_문자열로_로또_숫자를_생성하면_예외를_던진다() {
        assertThatThrownBy(() -> new LottoNumber("")).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource(value = { "'1, 2, 3', '1, 2, 3', 3", "'1, 2, 3', '1, 2, 4', 2"})
    void 두_로또_숫자를_비교하여_일치하는수를_반환한다(String source, String otherSource, int expected) {
        assertThat(new LottoNumber(source).matchCount(new LottoNumber(otherSource))).isEqualTo(expected);
    }
}
