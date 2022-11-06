package lotto;

import static org.assertj.core.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import lotto.numbers.AllNumbers;
import lotto.numbers.Lotto;

public class LottoTest {
    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5, 10, 20})
    public void generateNumbers(int purchaseCount) {
        Lotto lotto = new Lotto(purchaseCount);
        lotto.generateNumbers(purchaseCount);

        assertThat(lotto.getNumbersSize()).isEqualTo(purchaseCount);
        lotto.getNumbers().forEach(numbers -> assertThat(numbers.size()).isEqualTo(Lotto.TOTAL_NUMBERS_SIZE));
    }

    @ParameterizedTest
    @MethodSource("containsNumberParam")
    public void containsNumber(int index, int number) {
        Lotto lotto = new Lotto(10);
        lotto.generateNumbers(10);
        assertThat(lotto.containsNumber(index, number)).isInstanceOfAny(Boolean.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5, 10, 20})
    public void getNumbers(int purchaseCount) {
        Lotto lotto = new Lotto(purchaseCount);
        lotto.generateNumbers(purchaseCount);

        assertThat(lotto.getNumbers()).isNotEmpty();
        assertThat(AllNumbers.getNumbers().containsAll(lotto.getNumbers().get(0))).isEqualTo(true);
    }

    public static Stream<Arguments> containsNumberParam() {
        return Stream.of(
          Arguments.of(0, 44),
          Arguments.of(1, 13),
          Arguments.of(2, 23),
          Arguments.of(3, 38),
          Arguments.of(4, 41)
        );
    }
}
