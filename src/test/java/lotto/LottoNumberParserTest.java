package lotto;

import view.LottoNumbersParser;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class LottoNumberParserTest {

    @Test
    void 문자열을_쉼표로_구분해_숫자_리스트로_변환한다() {
        List<Integer> result = LottoNumbersParser.parse("1, 2, 3, 4, 5, 6");
        assertThat(result).containsExactly(1, 2, 3, 4, 5, 6);
    }

    @Test
    void 숫자가_아닌_문자열이_포함되면_예외를_던진다() {
        assertThatThrownBy(() -> {
            LottoNumbersParser.parse("1, abc, 3");
        }).isInstanceOf(NumberFormatException.class);
    }
}
