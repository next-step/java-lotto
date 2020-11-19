package lotto.dto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AnnounceWinningTest {

    @DisplayName("Winning 생성 테스트")
    @Test
    void of() {
        String input = "1,2,3,4,5,6";
        String bonus = "7";

        assertThat(AnnounceWinning.of(input, bonus))
                .isEqualToComparingFieldByField(AnnounceWinning.of(input, bonus));
    }
}
