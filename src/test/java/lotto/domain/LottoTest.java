package lotto.domain;

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
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LottoTest {

    @DisplayName("로또 번호의 개수는 6개여야 한다.")
    @MethodSource("lottoNumberSizeTestCase")
    @ParameterizedTest
    void lottoNumberSizeTest(List<Integer> numbers) {
        assertThatIllegalArgumentException()
            .isThrownBy(() -> Lotto.of(numbers, LottoNumber.of(45)));
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
            .isThrownBy(() -> Lotto.of(numbers, LottoNumber.of(15)));
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
            .isThrownBy(() -> Lotto.of(Arrays.asList(1, 1, 2, 3, 4, 5), LottoNumber.of(45)));
    }

    @DisplayName("두 로또 번호 일치 개수 검증")
    @MethodSource("lottoNumberMatchTestCase")
    @ParameterizedTest
    void lottoNumberMatchTest(List<Integer> numbers,
                              List<Integer> target,
                              int expected) {

        Lotto lotto1 = Lotto.of(numbers, LottoNumber.of(45));
        Lotto lotto2 = Lotto.of(target, LottoNumber.of(45));
        int actual = lotto1.getMatchCount(lotto2);

        assertEquals(expected, actual);
    }

    @SuppressWarnings("unused")
    private static Stream<Arguments> lottoNumberMatchTestCase() {
        return Stream.of(
            Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6),
                         Arrays.asList(4, 5, 6, 7, 8, 9),
                         3),
            Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6),
                         Arrays.asList(3, 4, 5, 6, 7, 8),
                         4),
            Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6),
                         Arrays.asList(2, 3, 4, 5, 6, 7),
                         5),
            Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6),
                         Arrays.asList(1, 2, 3, 4, 5, 6),
                         6)
        );
    }

    @DisplayName("로또 정상 생성 및 출력")
    @Test
    void success() {
        assertDoesNotThrow(() -> {
            Lotto lotto = Lotto.of(Arrays.asList(1, 2, 3, 4, 5, 6), LottoNumber.of(45));
            System.out.println(lotto);
        });
    }
}
