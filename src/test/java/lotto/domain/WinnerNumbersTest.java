package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

class WinnerNumbersTest {

    @Test
    void assertMatchForPrize() {
        List<Integer> lottoNumbersForTest = Arrays.asList(1, 2, 3, 4, 5, 6);

        WinnerNumbers winnerNumbers = new WinnerNumbers(lottoNumbersForTest);

        assertThat(winnerNumbers.isContain(6)).isEqualTo(true);
    }

}