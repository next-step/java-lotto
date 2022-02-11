package lotto.utils;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ConverterTest {

    private static final Lotto testLotto;

    static {
        List<Integer> testNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        testLotto = Lotto.from(testNumbers);
    }

    @DisplayName("배열을 입력 받아 Lotto 객체를 반환한다")
    @Test
    void 배열을_Lotto로_변환() {
        String[] givenNumbers = {"6", "5", "4", "3", "2", "1"};
        Lotto actual = Converter.inputToLotto(givenNumbers);

        assertThat(actual.getLottoNumbers()).hasSameElementsAs(testLotto.getLottoNumbers());
    }

    @DisplayName("Lotto 객체를 String으로 반환한다")
    @Test
    void Lotto를_문자열로_변환() {
        String actual = Converter.LottoToString(testLotto);
        String expected = "[1, 2, 3, 4, 5, 6]";

        assertThat(actual).isEqualTo(expected);
    }
}
