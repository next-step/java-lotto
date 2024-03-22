package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningNumbersTest {

    @Test
    void countMatchingWith() {
        WinningNumbers winningNumbers = WinningNumbers.of(Arrays.asList(1, 2, 3, 4, 5, 6));
        List<Integer> lottoNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        assertThat(winningNumbers.countMatchingWith(lottoNumbers)).isEqualTo(6);
    }
}
