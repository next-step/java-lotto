package step02.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class LottoGeneratorTest {

    private static Stream<Arguments> provideLottoNumbersRangeResult() {
        return Stream.of(
                Arguments.of(0, 10),
                Arguments.of(-1, 10),
                Arguments.of(0, 10)
        );
    }

    @DisplayName("생성자 (숫자범위 지정)")
    @ParameterizedTest
    @MethodSource("provideLottoNumbersRangeResult")
    public void test_LottoNumbers_Constructor(int from, int to) {
        assertThat(LottoGenerator.of(from, to)).isEqualTo(LottoGenerator.of(from, to));
    }
}
