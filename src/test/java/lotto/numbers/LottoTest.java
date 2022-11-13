package lotto.numbers;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoTest {
    @Test
    public void generator() {
        Lotto lotto = new Lotto();
        assertThat(lotto).isNotNull();
    }

    @ParameterizedTest
    @MethodSource("countSameNumberParam")
    public void countSameNumbers(List<Integer> numbers) {
        Lotto lotto = new Lotto();
        assertThat(lotto.countSameNumbers(numbers)).isInstanceOf(Integer.class);
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

    public static Stream<Arguments> countSameNumberParam() {
        return Stream.of(
          Arguments.of(List.of(1, 2, 3, 4, 5, 6)),
          Arguments.of(List.of(13, 26, 28, 33, 39)),
          Arguments.of(List.of(2, 23)),
          Arguments.of(List.of(3, 38, 40, 41)),
          Arguments.of(List.of(4, 41, 42))
        );
    }
}
