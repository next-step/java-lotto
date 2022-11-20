package lotto.numbers;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import lotto.enums.Ranks;

public class LottoTest {
    @Test
    public void generator() {
        Lotto lotto = new Lotto();
        assertThat(lotto).isNotNull();
    }

    @ParameterizedTest
    @MethodSource("getRankOfNumbersFailedParam")
    public void getRankOfNumbersFailed(List<Integer> numbers, int bonusNumber) {
        Lotto lotto = new Lotto();
        assertThatThrownBy(() -> {
            lotto.getRankOfNumbers(numbers, bonusNumber);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @MethodSource("getRankOfNumbersSuccessParam")
    public void getRankOfNumbers(List<Integer> numbers, int bonusNumber) {
        Lotto lotto = new Lotto();
        assertThat(lotto.getRankOfNumbers(numbers, bonusNumber)).isInstanceOf(Ranks.class);
    }

    @Test
    public void toStringTest() {
        IntStream.range(0, 5).forEach(i -> {
            Lotto lotto = new Lotto();
            String lottoInfo = lotto.toString();
            System.out.println(lottoInfo);
            assertThat(lottoInfo).isNotEmpty();
        });

    }

    public static Stream<Arguments> getRankOfNumbersSuccessParam() {
        return Stream.of(
          Arguments.of(List.of(1, 2, 3, 4, 5, 6), 7),
          Arguments.of(List.of(13, 26, 28, 33, 39, 44), 43),
          Arguments.of(List.of(2, 23, 34, 35, 41, 45), 7),
          Arguments.of(List.of(3, 38, 40, 41, 42, 43), 17),
          Arguments.of(List.of(4, 9, 16, 19, 26, 33), 40)
        );
    }

    public static Stream<Arguments> getRankOfNumbersFailedParam() {
        return Stream.of(
                Arguments.of(List.of(0, 2, 3, 4, 5, 6), 7),
                Arguments.of(List.of(13, 26, 28, 33, 39), 46),
                Arguments.of(List.of(2, 23), 44),
                Arguments.of(List.of(3, 38, 40, 41, 44, 46), 39),
                Arguments.of(List.of(4, 15, 33, 37, 41, 42), 42)
        );
    }
}
