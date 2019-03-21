package lotto.parser;

import lotto.domain.ticket.Lotto;
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
    public void 문자열을_로또객체로_변환() {
        // given
        String lottoNumbersString = "1, 2, 3, 4, 5, 6";
        String bonusNumberString = "45";

        // when
        Lotto lotto = LottoNumberParser.parse(lottoNumbersString, bonusNumberString);

        // then
        assertThat(lotto.getLottoNumbers()).containsExactly(1, 2, 3, 4, 5, 6);
        assertThat(lotto.getBonusNumber()).isEqualTo(Integer.parseInt(bonusNumberString));
    }
}
