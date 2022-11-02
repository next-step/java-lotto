package lotto;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class LottoTest {
    @ParameterizedTest
    @MethodSource("lottoTestParams")
    public void constructors(int purchaseAmount, int purchaseCount) {
        Lotto lotto = new Lotto(purchaseAmount);

        assertThat(lotto.getPurchaseCount()).isEqualTo(purchaseCount);
        assertThat(lotto.getNumbers()).isNotNull();
    }

    @ParameterizedTest
    @MethodSource("lottoTestParams")
    public void generateNumbers(int purchaseAmount, int purchaseCount) {
        Lotto lotto = new Lotto(purchaseAmount);
        lotto.generateNumbers();

        assertThat(lotto.getNumbers().size()).isEqualTo(purchaseCount);
        lotto.getNumbers().forEach(numbers -> {
            assertThat(numbers.size()).isEqualTo(Lotto.TOTAL_NUMBERS);
        });
    }

    public static Stream<Arguments> lottoTestParams() {
        return Stream.of(
          Arguments.of(1000, 1000 / Lotto.AMOUNT),
          Arguments.of(5000, 5000 / Lotto.AMOUNT),
          Arguments.of(10000, 10000 / Lotto.AMOUNT),
          Arguments.of(14000, 14000 / Lotto.AMOUNT),
          Arguments.of(100000, 100000 / Lotto.AMOUNT)
        );
    }
}
