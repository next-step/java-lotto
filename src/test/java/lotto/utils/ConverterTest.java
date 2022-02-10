package lotto.utils;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ConverterTest {

    private static final Lotto testLotto;

    static {
        List<LottoNumber> testNumbers = Arrays.asList(
            new LottoNumber(1),
            new LottoNumber(2),
            new LottoNumber(3),
            new LottoNumber(4),
            new LottoNumber(5),
            new LottoNumber(6)
        );
        testLotto = Lotto.of(testNumbers);
    }

    @DisplayName("배열을 입력 받아 Lotto 객체를 반환한다")
    @Test
    void 배열을_Lotto로_변환() {
        String[] givenNumbers = {"1", "2", "3", "4", "5", "6"};
        Lotto actual = Converter.inputToLotto(givenNumbers);

        assertThat(actual).isEqualTo(testLotto);
    }

    @DisplayName("Lotto 객체를 String으로 반환한다")
    @Test
    void Lotto를_문자열로_변환() {
        String actual = Converter.LottoToString(testLotto);
        String expected = "[1, 2, 3, 4, 5, 6]";

        assertThat(actual).isEqualTo(expected);
    }
}