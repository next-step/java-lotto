package domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningNumbersTest {
    @Test
    public void has_6_numbers() {
        WinningNumbers winningNumbers = new WinningNumbers(1,2,3,4,5,6);
        assertThat(winningNumbers.getLottoNumbers()).hasSize(6);
    }
}
