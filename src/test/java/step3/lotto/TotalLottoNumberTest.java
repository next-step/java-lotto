package step3.lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import step3.lotto.exception.InvalidLottoNumberException;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class TotalLottoNumberTest {

    @ParameterizedTest
    @DisplayName("로또 번호와 보너스 번호가 겹치는 경우 에러가 발생한다")
    @MethodSource("duplicateParam")
    void duplicatedNumberTest(List<Integer> numbers, Integer bonusNum) {
        LottoNumber lottoNumber = new LottoNumber(numbers);
        BonusNumber bonusNumber = new BonusNumber(bonusNum);
        assertThrows(InvalidLottoNumberException.class, () -> new TotalLottoNumber(lottoNumber, bonusNumber));
    }

    @ParameterizedTest
    @DisplayName("로또 번호와 보너스 번호가 겹치지 않는 경우 통과한다")
    @MethodSource("validParam")
    void validNumberTest(List<Integer> numbers, Integer bonusNum) {
        LottoNumber lottoNumber = new LottoNumber(numbers);
        BonusNumber bonusNumber = new BonusNumber(bonusNum);
        assertDoesNotThrow(() -> new TotalLottoNumber(lottoNumber, bonusNumber));
    }

    private static Stream<Arguments> validParam() {
        return Stream.of(
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6), 7),
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6), 8),
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6), 10),
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6), 13)
        );
    }

    private static Stream<Arguments> duplicateParam() {
        return Stream.of(
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6), 1),
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6), 2),
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6), 3),
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6), 4),
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6), 5),
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6), 6)
        );
    }
}