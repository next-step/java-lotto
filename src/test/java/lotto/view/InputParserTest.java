package lotto.view;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputParserTest {

    @Test
    void 구입_금액을_숫자로_변환한다() {
        assertThat(InputParser.parseAmount("14000")).isEqualTo(14000);
    }

    @ParameterizedTest
    @ValueSource(strings = {"abc", "", "1000원"})
    void 구입_금액이_숫자가_아니면_예외가_발생한다(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> InputParser.parseAmount(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"1, 2, 3, 4, 5, 6", "1,2,3,4,5,6", " 1 ,2 , 3,4,5 ,6 "})
    void 쉼표로_구분된_문자열을_공백을_제거해_숫자_리스트로_변환한다(String input) {
        assertThat(InputParser.parseNumbers(input)).containsExactly(1, 2, 3, 4, 5, 6);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1, 2, a, 4, 5, 6", "1, , 3, 4, 5, 6", "1, 2, 3, 4, 5, 6,"})
    void 당첨_번호에_숫자가_아닌_값이_있으면_예외가_발생한다(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> InputParser.parseNumbers(input));
    }
}
