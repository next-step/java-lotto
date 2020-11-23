package step04.domain;

import exception.OutOfLottoNumberRangeException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class LottoNumberParserTest {
    @DisplayName("입력받은 lottoNumbers 를 토큰화")
    @Test
    public void test_execute() {
        assertThat(
                LottoNumberParser.execute("1, 2, 3, 4, 5, 6")
        ).isEqualTo(Lotto.of(Arrays.asList(1, 2, 3, 4, 5, 6)));
    }

    private static Stream<String> provideInvalidInputResult() {
        return Stream.of("-1, -10, -11, -100, 0, 1000");
    }

    @DisplayName("validateNumber 예외 테스트")
    @ParameterizedTest
    @MethodSource("provideInvalidInputResult")
    public void test_validateNumber_ThrowException(String inValidInput) {
        assertThatExceptionOfType(OutOfLottoNumberRangeException.class)
                .isThrownBy(() -> {
                    LottoNumberParser.execute(inValidInput);
                });
    }

    private static Stream<Arguments> provideLottoNumberListResult() {
        return Stream.of(
                Arguments.of(
                        Arrays.asList(
                                "1, 2, 3, 4, 5, 6",
                                "1, 2, 3, 4, 5, 10",
                                "1, 10, 13, 14, 15, 20"
                        ),
                        Lottos.of(Arrays.asList(
                                Lotto.of(Arrays.asList(1, 2, 3, 4, 5, 6)),
                                Lotto.of(Arrays.asList(1, 2, 3, 4, 5, 10)),
                                Lotto.of(Arrays.asList(1, 10, 13, 14, 15, 20))
                        ))
                ));
    }

    @DisplayName("lottoNumbers List Lottos 로 파싱")
    @ParameterizedTest
    @MethodSource("provideLottoNumberListResult")
    void test_executeByMultiple(List<String> lottosNumbers, Lottos lottos) {
        assertThat(LottoNumberParser.executeByMultiple(lottosNumbers))
                .isEqualTo(lottos);
    }
}
