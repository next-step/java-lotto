package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningNumbersTest {

    @DisplayName("입력한 문자열이 list로 생성됨을 확")
    @Test
    void winningNumbers() {
        List<Integer> winningNumbers = WinningNumbers.get("1,2,3,4,5,6");
        assertThat(winningNumbers).hasSize(6);
    }
}
