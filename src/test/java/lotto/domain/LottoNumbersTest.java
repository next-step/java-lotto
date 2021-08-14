package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

class LottoNumbersTest {

    @ParameterizedTest(name = "로또 숫자가 6개가 아닌 경우 예외가 발생한다.")
    @MethodSource("provideNumbersWithInvalidSize")
    public void lottoNumberSizeExceptionTest(List<Integer> numbers) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> LottoNumbers.of(createLottoNumbers(numbers)))
                .withMessageContainingAll(convertToStrings(numbers));
    }

    private static Stream<Arguments> provideNumbersWithInvalidSize() {
        return Stream.of(
                Arguments.of(Arrays.asList(1,2,3,4,5)),
                Arguments.of(Arrays.asList(1,2,3,4,5,6,7))
        );
    }

    @DisplayName("로또 숫자가 중복되는 경우 예외가 발생한다.")
    @Test
    public void lottoNumberDuplicatedExceptionTest() {
        List<Integer> numbers = Arrays.asList(1, 1, 5, 23, 41, 45);
        assertThatIllegalArgumentException()
                .isThrownBy(() -> LottoNumbers.of(createLottoNumbers(numbers)))
                .withMessageContainingAll(convertToStrings(numbers));
    }

    @DisplayName("중복되지 않는 6개의 로또 숫자로 로또 티켓을 생성할 수 있다.")
    @Test
    public void lottoNumbersCreateTest() {
        assertThatCode(() -> LottoNumbers.of(createLottoNumbers(Arrays.asList(1, 3, 5, 23, 41, 45))))
                .doesNotThrowAnyException();
    }

    private List<LottoNumber> createLottoNumbers(List<Integer> numbers) {
        return numbers.stream()
                .map(LottoNumber::of)
                .collect(Collectors.toList());
    }

    private String[] convertToStrings(List<Integer> numbers) {
        return numbers.stream()
                .map(String::valueOf)
                .toArray(String[]::new);
    }

    @DisplayName("두 로또 숫자들을 비교해서 일치하는 숫자의 수를 알 수 있다.")
    @Test
    public void hitTest() {
        LottoNumbers first = LottoNumbers.of(createLottoNumbers(Arrays.asList(1,2,3,4,5,6)));
        LottoNumbers second = LottoNumbers.of(createLottoNumbers(Arrays.asList(1,2,3,7,8,9)));
        assertThat(first.countOfMatch(second))
                .isEqualTo(3);
    }

}