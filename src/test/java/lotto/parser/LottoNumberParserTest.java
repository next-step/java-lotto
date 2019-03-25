package lotto.parser;

import lotto.domain.LottoNumber;
import lotto.domain.WinningLotto;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoNumberParserTest {
    @Test
    public void 숫자_문자열을_LottoNumber_객체로_변환() {
        // given
        String oneString = "1";

        // when
        LottoNumber one = LottoNumberParser.parseLottoNumber(oneString);

        // then
        assertThat(one).isEqualTo(LottoNumber.getInstance(1));
    }

    @Test
    public void 콤마_단위로_나뉘어진_숫자를_LottoNumber_list로_변환() {
        // given
        String numbersString = "1, 2, 3, 4, 5, 6";

        // when
        List<LottoNumber> lottoNumbers = LottoNumberParser.parseLottoNumbers(numbersString);

        // then
        LottoNumber one = LottoNumber.getInstance(1);
        LottoNumber two = LottoNumber.getInstance(2);
        LottoNumber three = LottoNumber.getInstance(3);
        LottoNumber four = LottoNumber.getInstance(4);
        LottoNumber five = LottoNumber.getInstance(5);
        LottoNumber six = LottoNumber.getInstance(6);

        assertThat(lottoNumbers).containsExactly(one, two, three, four, five, six);
    }

    @Test
    public void 문자열을_WinningLotto_객체로_변환() {
        // given
        String lottoNumbersString = "1, 2, 3, 4, 5, 6";
        String bonusNumberString = "45";

        // when
        WinningLotto winner = LottoNumberParser.parseWinningLotto(lottoNumbersString, bonusNumberString);

        // then
        WinningLotto sameAsWinner = new WinningLotto(getLottoNumbers(1, 2, 3, 4, 5, 6), LottoNumber.getInstance(45));
        assertThat(winner.isEqualTo(sameAsWinner)).isTrue();
    }

    private List<LottoNumber> getLottoNumbers(int... numbers) {
        return Arrays.stream(numbers)
                .mapToObj(LottoNumber::getInstance)
                .collect(Collectors.toList());
    }
}
