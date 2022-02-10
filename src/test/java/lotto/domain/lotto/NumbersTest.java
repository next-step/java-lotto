package lotto.domain.lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class NumbersTest {

    private Numbers source;

    static Stream<Arguments> comparisonNumbers() {
        return Stream.of(
            Arguments.of(getNumberList(1,2,3,4,5,6), 6),
            Arguments.of(getNumberList(2,3,4,5,6,7), 5),
            Arguments.of(getNumberList(3,4,5,6,7,8), 4),
            Arguments.of(getNumberList(4,5,6,7,8,9), 3),
            Arguments.of(getNumberList(5,6,7,8,9,10), 2),
            Arguments.of(getNumberList(6,7,8,9,10,11), 1),
            Arguments.of(getNumberList(7,8,9,10,11,12), 0)
        );
    }

    static Stream<Arguments> comparisonBonuses() {
        return Stream.of(
            Arguments.of(5, true),
            Arguments.of(7, false)
        );
    }

    static List<Number> getNumberList(Integer ...values) {
        return Stream.of(values)
            .map(Number::new)
            .collect(Collectors.toList());
    }

    @BeforeEach
    void setUp() {
        source = new Numbers(getNumberList(1, 2, 3, 4, 5, 6));
    }

    @DisplayName("로또 넘버와 비교대상군이 주어졌을 때, 적절한 일치 숫자 개수를 반환해야한다.")
    @ParameterizedTest
    @MethodSource("comparisonNumbers")
    void testCountMatchesValid(final List<Number> comparison, final int matches) {
        assertThat(source.countMatches(comparison))
            .isEqualTo(matches);
    }

    @DisplayName("로또 넘버와 보너스 넘버가 주어졌을 때, 로또 넘버에 보너스가 포함된 경우 true, 아닌 경우 false를 반환해야 한다.")
    @ParameterizedTest
    @MethodSource("comparisonBonuses")
    void testHasBonusValid(final int bonusNumber, final boolean hasBonus) {
        assertThat(source.hasBonus(new Number(bonusNumber)))
            .isEqualTo(hasBonus);
    }

    @DisplayName("넘버 리스트에 중복이 존재하는 경우, 에러를 발생해야 한다.")
    @Test
    void testDuplicatedNumbersWillThrowException() {
        assertThatThrownBy(() -> new Numbers(getNumberList(1, 1, 8, 8, 15, 45)))
            .isInstanceOf(IllegalArgumentException.class);
    }

}
