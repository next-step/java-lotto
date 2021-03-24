package lotto;

import lotto.dto.WinningNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinningNumberTest {

    @Test
    @DisplayName("보너스볼은 당첨번호와 중복되면 에러가 발생한다.")
    void bonusBallUnique() {
        int bonusBall = 5;
        assertThatThrownBy(() -> {
            new WinningNumber(Arrays.asList(1, 2, 3, 4, 5, 6), bonusBall);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
