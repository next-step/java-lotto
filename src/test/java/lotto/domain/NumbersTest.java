package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class NumbersTest {

    static Stream<Arguments> countSameNumber() {
        Numbers.Builder builder = Numbers.builder();
        Numbers numbers = builder.range(1, 4).build();
        return Stream.of(
                arguments(numbers, builder.range(1, 2).build(), 1),
                arguments(numbers, builder.range(1, 3).build(), 2),
                arguments(numbers, builder.range(1, 4).build(), 3)
        );
    }

    @ParameterizedTest
    @DisplayName("Numbers객체와 비교하여 같은 숫자가 몇개인지 확인")
    @MethodSource
    void countSameNumber(Numbers numbers, Numbers numbersCompared, int sameNumberCountExpected) {
        int sameNumberCount = numbers.countSameNumber(numbersCompared);

        assertThat(sameNumberCount).isEqualTo(sameNumberCountExpected);
    }
}
