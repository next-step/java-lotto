package lotto.dto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningTest {

    @DisplayName("Winning 생성 테스트")
    @Test
    void of() {
        String input = "1,2,3,4,5,6";
        assertThat(Winning.of(input))
                .isEqualToComparingFieldByField(Winning.of(input));
    }
}
