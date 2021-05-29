package lotto;

import lotto.exception.LottoNumberRangeException;
import lotto.exception.LottoSizeOrDuplicateException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoValidationUtilsTest {
    @DisplayName("로또 번호 길이 유효성 체크")
    @ParameterizedTest
    @MethodSource("sizeErrorNumber")
    void 중복_사이즈_테스트(List<Integer> lottoNumber) {
        assertThatThrownBy(() -> LottoValidationUtils.checkDuplicateAndSize(lottoNumber))
                .isInstanceOf(LottoSizeOrDuplicateException.class);
    }

    static Stream sizeErrorNumber() {
        return Stream.of(
                Arrays.asList(1, 2, 3, 4, 5, 5),
                Arrays.asList(1, 2, 3, 4, 5),
                Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8),
                Arrays.asList(1, 5, 5, 6, 6, 7, 7, 8, 8, 9, 9)
        );
    }

    @DisplayName("오류 문자가 있는지 체크")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,r,3,4,5", "1,2,4.,3,4,5"})
    void 숫자_아닌_값_존재_여부_체크(String winNumber) {
        assertThatThrownBy(() -> LottoValidationUtils.lottoNumberToListNumbers(winNumber))
                .isInstanceOf(NumberFormatException.class);
    }

    @DisplayName("로또 번호 범위 1~45 체크")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,55,3,4,5", "1,2,65,3,4,5", "1,2,46,3,4,5"})
    void 로또_번호_범위_체크(String winNumber) {
        assertThatThrownBy(() -> LottoValidationUtils.lottoNumberToListNumbers(winNumber))
                .isInstanceOf(LottoNumberRangeException.class);
    }
}
