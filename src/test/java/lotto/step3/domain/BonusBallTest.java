package lotto.step3.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

class BonusBallTest {

    @Test
    void create() {
        BonusBall bonusBall = new BonusBall(7);
        assertThat(bonusBall).isEqualTo(new BonusBall(7));
    }

    @Test
    @DisplayName("보너스볼은 당첨번호에 포함 x -> IllegalArgumentException")
    void validation() {
        Lotto winningNumbers = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThatThrownBy(() -> new BonusBall(7, winningNumbers))
                .isInstanceOf(IllegalArgumentException.class);
        //정상
        assertThatCode(() -> new BonusBall(1, winningNumbers))
                .doesNotThrowAnyException();
    }

}