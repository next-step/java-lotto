package step3.lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import step3.lotto.exception.InvalidLottoNumberException;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LottoNumberTest {

    @ParameterizedTest
    @DisplayName("올바른 로또 번호 테스트")
    @MethodSource("validLottoNumbers")
    void validNumberTest(List<Integer> numbers) {
        assertDoesNotThrow(() -> new LottoNumber(numbers));
    }

    @ParameterizedTest
    @DisplayName("올바르지 않은 로또 번호 테스트")
    @MethodSource("outOfBoundLottoNumbers")
    void invalidNumberTest(List<Integer> numbers) {
        assertThrows(InvalidLottoNumberException.class, () -> new LottoNumber(numbers));
    }

    private static Stream<Arguments> validLottoNumbers() {
        return Stream.of(
                Arguments.of(Arrays.asList(1,2,3,4,5,6)),
                Arguments.of(Arrays.asList(1,2,5,10,34,32)),
                Arguments.of(Arrays.asList(10,22,13,24,35,36))
        );
    }

    private static Stream<Arguments> outOfBoundLottoNumbers() {
        return Stream.of(
                Arguments.of(Arrays.asList(0,2,3,4,5,6)),
                Arguments.of(Arrays.asList(-1,2,5,10,34,32)),
                Arguments.of(Arrays.asList(155,22,13,24,35,36))
        );
    }

}