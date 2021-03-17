package study.lotto.view.dto;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import study.lotto.domain.LottoNumber;
import study.lotto.exception.LottoException;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class RequestWinningNumberTest {

    private static Stream<Arguments> winningNumberEntry() {
        List<LottoNumber> lottoNumbers = Arrays.asList(
                new LottoNumber(1), new LottoNumber(2),
                new LottoNumber(3), new LottoNumber(4),
                new LottoNumber(5), new LottoNumber(6));
        return Stream.of(
            Arguments.of("1,2,3,4,5,6", lottoNumbers)
        );
    }
    @ParameterizedTest(name = "{0} 입력 시 문자열 파싱 테스트")
    @MethodSource(value = "winningNumberEntry")
    void requestWinningNumber(String given, List<LottoNumber> expected) {
        // given
        RequestWinningNumber winningNumber = new RequestWinningNumber(given);
        // when
        List<LottoNumber> winningNumbers = winningNumber.getWinningNumbers();
        // then
        assertThat(winningNumbers).isEqualTo(expected);
    }

    @ParameterizedTest(name = "{0} 입력 시 예외 처리")
    @ValueSource(strings = {"1,a", "-1"})
    void testCase(String given) {
        assertThatExceptionOfType(LottoException.class)
                .isThrownBy(() -> new RequestWinningNumber(given));
    }
}
