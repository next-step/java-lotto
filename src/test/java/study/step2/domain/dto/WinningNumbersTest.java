package study.step2.domain.dto;

import java.util.List;

import org.junit.jupiter.api.Test;
import study.step2.domain.WinningNumbers;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningNumbersTest {

    @Test
    void 숫자_포함() {
        WinningNumbers winningNumbers = new WinningNumbers(List.of(1, 2, 3, 4, 5, 6));
        assertThat(winningNumbers.toIntegers()).contains(3);
    }
}
