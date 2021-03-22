package lotto.step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTest {

    @DisplayName("로또는 6개의 숫자로 이루어짐")
    @ParameterizedTest
    @MethodSource("provideLottoOfSixNumbers")
    void lotto_숫자6개구성(int[] input, int[] expected) {
        Lotto lotto = Lotto.of(input);
        assertThat(lotto).isEqualTo(Lotto.of(expected));
    }

    private static Stream<Arguments> provideLottoOfSixNumbers() {
        return Stream.of(
                Arguments.of(new int[]{1, 3, 5, 7, 9, 11}, new int[]{1, 3, 5, 7, 9, 11}),
                Arguments.of(new int[]{5, 10, 13, 17, 29, 31}, new int[]{5, 10, 13, 17, 29, 31}),
                Arguments.of(new int[]{21, 33, 34, 37, 40, 45}, new int[]{21, 33, 34, 37, 40, 45})
        );
    }

}