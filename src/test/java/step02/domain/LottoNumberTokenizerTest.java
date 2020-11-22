package step02.domain;

import exception.OutOfLottoNumberRangeException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import step02.Mock;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class LottoNumberTokenizerTest {
    @DisplayName("입력받은 WinningNumbers 를 토큰화")
    @Test
    public void test_execute() {
        assertThat(
                WinningNumberTokenizer.execute("1, 2, 3, 4, 5, 6", LottoGenerator.of(1, 45))
        ).isEqualTo(Mock.makeLotto(Arrays.asList(1, 2, 3, 4, 5, 6)));
    }

    private static Stream<String> provideInvalidInputResult() {
        return Stream.of("-1, -10, -11, -100, 0, 1000");
    }

    @DisplayName("validateNumber 예외 테스트")
    @ParameterizedTest
    @MethodSource("provideInvalidInputResult")
    public void test_validateNumber_ThrowException(String inValidInput) {
        LottoGenerator lottoGenerator = LottoGenerator.of(1, 10);
        assertThatExceptionOfType(OutOfLottoNumberRangeException.class)
                .isThrownBy(() -> {
                   WinningNumberTokenizer.execute(inValidInput, lottoGenerator);
                });
    }

}
