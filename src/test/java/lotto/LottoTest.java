package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static lotto.Lotto.LOTTO_NUMBER_COUNT;
import static lotto.Lotto.MAX_LOTTO_NUMBER;
import static lotto.Lotto.MIN_LOTTO_NUMBER;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class LottoTest {

    @Test
    @DisplayName("로또 번호는 정렬되어야 한다")
    void lottoNumbersAreSorted() {
        Lotto lotto = Lotto.createRandomly();
        List<Integer> lottoNumbers = LottoParserForTest.parse(lotto);
        Assertions.assertThat(lottoNumbers).isSorted();
    }

    @Test
    @DisplayName("로또 번호는 서로 다른 6개의 숫자여야 한다")
    void lottoNumbersAreDifferent() {
        Lotto lotto = Lotto.createRandomly();
        List<Integer> lottoNumbers = LottoParserForTest.parse(lotto);
        Assertions.assertThat(lottoNumbers).doesNotHaveDuplicates();
    }

    @ParameterizedTest(name = "[{index}] 입력: {0}")
    @MethodSource("provideInvalidSizeCases")
    @DisplayName("로또 번호 개수 예외 테스트")
    void testInvalidSize(List<Integer> numbers, String expectedMessage) {
        assertThatThrownBy(() -> Lotto.create(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(expectedMessage);
    }

    static Stream<Arguments> provideInvalidSizeCases() {
        return Stream.of(
                Arguments.of(List.of(), "로또 번호는 " + LOTTO_NUMBER_COUNT + "개여야 합니다."),
                Arguments.of(List.of(1, 2, 3, 4, 5), "로또 번호는 " + LOTTO_NUMBER_COUNT + "개여야 합니다."),
                Arguments.of(List.of(1, 2, 3, 4, 5, 6, 7), "로또 번호는 " + LOTTO_NUMBER_COUNT + "개여야 합니다.")
        );
    }

    @ParameterizedTest(name = "[{index}] 입력: {0}")
    @MethodSource("provideOutOfRangeCases")
    @DisplayName("로또 번호 범위 예외 테스트")
    void testOutOfRangeNumbers(List<Integer> numbers, String expectedMessage) {
        assertThatThrownBy(() -> Lotto.create(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(expectedMessage);
    }

    static Stream<Arguments> provideOutOfRangeCases() {
        return Stream.of(
                Arguments.of(List.of(0, 2, 3, 4, 5, 6), "로또 번호는 " + MIN_LOTTO_NUMBER + "이상 " + MAX_LOTTO_NUMBER + "이하의 숫자여야 합니다."),
                Arguments.of(List.of(1, 2, 3, 4, 5, 46), "로또 번호는 " + MIN_LOTTO_NUMBER + "이상 " + MAX_LOTTO_NUMBER + "이하의 숫자여야 합니다."),
                Arguments.of(List.of(-1, 10, 20, 30, 40, 45), "로또 번호는 " + MIN_LOTTO_NUMBER + "이상 " + MAX_LOTTO_NUMBER + "이하의 숫자여야 합니다.")
        );
    }

    @ParameterizedTest(name = "[{index}] 입력: {0}")
    @MethodSource("provideDuplicateCases")
    @DisplayName("로또 번호 중복 예외 테스트")
    void testDuplicateNumbers(List<Integer> numbers, String expectedMessage) {
        assertThatThrownBy(() -> Lotto.create(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(expectedMessage);
    }

    static Stream<Arguments> provideDuplicateCases() {
        return Stream.of(
                Arguments.of(List.of(1, 1, 2, 3, 4, 5), "로또 번호는 서로 다른 숫자여야 합니다."),
                Arguments.of(List.of(10, 11, 12, 12, 13, 14), "로또 번호는 서로 다른 숫자여야 합니다."),
                Arguments.of(List.of(7, 8, 9, 10, 7, 11), "로또 번호는 서로 다른 숫자여야 합니다.")
        );
    }

    @ParameterizedTest(name = "[{index}] 입력: {0}")
    @MethodSource("provideSortedCases")
    @DisplayName("로또 번호 정렬 예외 테스트")
    void testSortedNumbers(List<Integer> numbers, String expectedMessage) {
        assertThatThrownBy(() -> Lotto.create(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(expectedMessage);
    }

    static Stream<Arguments> provideSortedCases() {
        return Stream.of(
                Arguments.of(List.of(6, 5, 4, 3, 2, 1), "로또 번호는 오름차순으로 정렬되어야 합니다."),
                Arguments.of(List.of(45, 44, 43, 42, 41, 40), "로또 번호는 오름차순으로 정렬되어야 합니다."),
                Arguments.of(List.of(8, 7, 6, 5, 4, 3), "로또 번호는 오름차순으로 정렬되어야 합니다.")
        );
    }

    private static class LottoParserForTest {

        private static final String DELIMITER = ",";

        public static List<Integer> parse(Lotto lotto) {
            return Arrays.stream(lotto.toString()
                            .substring(1, lotto.toString().length() - 1)
                            .split(DELIMITER))
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        }
    }
}
