package lotto.parser;

import lotto.domain.Lotto;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoNumberParserTest {
    @Test
    public void 공백_제거() {
        // given
        String source = "   a b       c  d    ";

        // when
        String result = LottoNumberParser.removeWhiteSpace(source);

        // then
        assertThat(result.indexOf(' ')).isEqualTo(-1);
    }

    @Test
    public void 콤마_단위로_나뉘어진_숫자를_int_list로_변환() {
        // given
        String numbersString = "1, 2, 3, 4, 5, 6";

        // when
        List<Integer> ints = LottoNumberParser.parseToIntList(numbersString);

        // then
        assertThat(ints).containsExactly(1, 2, 3, 4, 5, 6);
    }

    @Test
    public void 콤마_단위로_나뉘어진_로또번호_Lotto로_변환() {
        // given
        String lottoNumbersString = "1, 2, 3, 4, 5, 6";

        // when
        Lotto lotto = LottoNumberParser.parse(lottoNumbersString);

        // then
        assertThat(lotto.getNumbers())
                .containsExactly(1, 2, 3, 4, 5, 6);
    }
}
