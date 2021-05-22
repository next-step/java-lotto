package step3.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LottoNumbersTest {

    @DisplayName("로또 번호의 개수는 6개여야 한다.")
    @MethodSource("lottoNumberSizeTestCase")
    @ParameterizedTest
    void lottoNumberSizeTest(List<Integer> numbers) {
        assertThatIllegalArgumentException()
            .isThrownBy(() -> new LottoNumbers(numbers));
    }

    @SuppressWarnings("unused")
    private static Stream<Arguments> lottoNumberSizeTestCase() {
        return Stream.of(
            Arguments.of(Collections.emptyList()),
            Arguments.of(Collections.singletonList(1)),
            Arguments.of(Arrays.asList(1, 2)),
            Arguments.of(Arrays.asList(1, 2, 3)),
            Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6, 7))
        );
    }

    @DisplayName("로또 번호는 1 ~ 45 사이의 수만 사용할 수 있다.")
    @MethodSource("lottoNumberRangeTestCase")
    @ParameterizedTest
    void lottoNumberRangeTest(List<Integer> numbers) {
        assertThatIllegalArgumentException()
            .isThrownBy(() -> new LottoNumbers(numbers));
    }

    @SuppressWarnings("unused")
    private static Stream<Arguments> lottoNumberRangeTestCase() {
        return Stream.of(
            Arguments.of(Arrays.asList(1, 46, 2, 3, 4, 5)),
            Arguments.of(Arrays.asList(0, 45, 2, 3, 4, 5))
        );
    }

    @DisplayName("로또 번호는 중복될 수 없다.")
    @Test
    void duplicateTest() {
        assertThatIllegalArgumentException()
            .isThrownBy(() -> new LottoNumbers(Arrays.asList(1, 1, 2, 3, 4, 5)));
    }

    @DisplayName("로또 번호 비교 검증")
    @MethodSource("numberMatchTestCase")
    @ParameterizedTest
    void numberMatchTest(LottoNumbers lottoNumbers,
                         LottoNumbers target,
                         int expected) {
        int actual = lottoNumbers.getMatchCount(target);
        assertEquals(expected, actual);
    }

    @SuppressWarnings("unused")
    private static Stream<Arguments> numberMatchTestCase() {
        return Stream.of(
            Arguments.of(LottoNumbers.of(Arrays.asList(1, 2, 3, 4, 5, 6)),
                         LottoNumbers.of(Arrays.asList(4, 5, 6, 7, 8, 9)),
                         3),
            Arguments.of(LottoNumbers.of(Arrays.asList(1, 2, 3, 4, 5, 6)),
                         LottoNumbers.of(Arrays.asList(3, 4, 5, 6, 7, 8)),
                         4),
            Arguments.of(LottoNumbers.of(Arrays.asList(1, 2, 3, 4, 5, 6)),
                         LottoNumbers.of(Arrays.asList(2, 3, 4, 5, 6, 7)),
                         5),
            Arguments.of(LottoNumbers.of(Arrays.asList(1, 2, 3, 4, 5, 6)),
                         LottoNumbers.of(Arrays.asList(1, 2, 3, 4, 5, 6)),
                         6)
            );
    }
}
