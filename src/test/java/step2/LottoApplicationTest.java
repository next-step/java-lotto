package step2;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoApplicationTest {
    @Test
    void purchaseAmountTest() {
        final int inputValue = 14000;
        final int count = LottoApplication.getNumberOfPurchases(inputValue);
        final int expected = 14;
        assertThat(count).isEqualTo(expected);
    }

    @Test
    void issueLottos() {
        final int numberOfPurchases = 14;
        final Lottos lottos = LottoApplication.issueLottos(numberOfPurchases);
        final int actual = lottos.count();
        final int expected = numberOfPurchases;
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void convertTest() {
        final String inputString = "1, 2, 3, 4, 5, 6";
        final List<Integer> actual = LottoApplication.convertStringToListOfNumber(inputString);
        final List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5, 6);
        assertThat(actual).isEqualTo(expected);
    }
}
