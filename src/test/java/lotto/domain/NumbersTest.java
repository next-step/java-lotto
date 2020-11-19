package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class NumbersTest {

    static Stream<Arguments> countSameNumber() {
        Numbers.Builder builder = Numbers.builder();
        Numbers numbers = builder.range(1, 7).build();
        return Stream.of(
                arguments(numbers, builder.range(1, 7).build(), 6),
                arguments(numbers, builder.range(2, 8).build(), 5),
                arguments(numbers, builder.range(3, 9).build(), 4)
        );
    }

    @ParameterizedTest
    @DisplayName("Numbers객체와 비교하여 같은 숫자가 몇개인지 확인")
    @MethodSource
    void countSameNumber(Numbers numbers, Numbers numbersCompared, int sameNumberCountExpected) {
        int sameNumberCount = numbers.countSameNumber(numbersCompared);

        assertThat(sameNumberCount).isEqualTo(sameNumberCountExpected);
    }

    @Test
    @DisplayName("Numbers에 개수가 6개가 아닐 때")
    void createNumbers_sizeIsNot6() {
        assertThatThrownBy(() ->
                Numbers.builder().range(1, 8).build())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Numbers size wrong");
    }

    @Test
    @DisplayName("Numbers에 중복된 수가 들어갔을 때")
    void createNumbers_insertDuplicatedNumbers() {
        assertThatThrownBy(() ->
                Numbers.builder().add(1).add(1).build())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Duplicate numbers in list to make set");
    }
}
