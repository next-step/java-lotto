package domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningNumbersTest {
    @Test
    public void has_6_numbers() {
        WinningNumbers winningNumbers = new WinningNumbers(1,2,3,4,5,6);
        assertThat(winningNumbers.getLottoNumbers()).hasSize(6);
    }

    @Test
    public void check_this_lotto_number_contains() {
        WinningNumbers winningNumbers = new WinningNumbers(1,2,3,4,5,6);
        assertThat(winningNumbers.contains(new LottoNumber(3))).isTrue();
    }
}
