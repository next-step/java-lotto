package step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LotteryNumberTest {
    @DisplayName("6개의 번호를 제공해야 한다")
    @Test
    void satisfyConstructor() {
        assertThatThrownBy(() -> LotteryNumber.of(1, 2, 2, 3, 4, 5)) //
                .isInstanceOf(NotEnoughNumberException.class);
    }

    @DisplayName("주어진 숫자셋과 교집합의 갯수를 구할 수 있다.")
    @ParameterizedTest
    @MethodSource("provideIntersectionTest")
    void intersection(LotteryNumber source, LotteryNumber target, int matched) {
        assertThat(source.getMatched(target)).isEqualTo(matched);
    }

    private static Stream<Arguments> provideIntersectionTest() {
        //@formatter:off
        return Stream.of(
                Arguments.of(LotteryNumber.of(1, 2, 3, 4, 5, 6), LotteryNumber.of(1, 2, 3, 4, 5, 6),        6),
                Arguments.of(LotteryNumber.of(1, 2, 3, 4, 5, 6), LotteryNumber.of(11, 2, 3, 4, 5, 6),       5),
                Arguments.of(LotteryNumber.of(1, 2, 3, 4, 5, 6), LotteryNumber.of(11, 12, 3, 4, 5, 6),      4),
                Arguments.of(LotteryNumber.of(1, 2, 3, 4, 5, 6), LotteryNumber.of(11, 12, 13, 4, 5, 6),     3),
                Arguments.of(LotteryNumber.of(1, 2, 3, 4, 5, 6), LotteryNumber.of(11, 12, 13, 14, 5, 6),    2),
                Arguments.of(LotteryNumber.of(1, 2, 3, 4, 5, 6), LotteryNumber.of(11, 12, 13, 14, 15, 6),   1),
                Arguments.of(LotteryNumber.of(1, 2, 3, 4, 5, 6), LotteryNumber.of(11, 12, 13, 14, 15, 16),  0)
        );
        //@formatter:on
    }

}
