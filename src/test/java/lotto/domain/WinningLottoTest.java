package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningLottoTest {
    private WinningLotto winningLotto;
    private String numbers = "1,2,3,4,5,6";
    private int bonusNumber = 7;

    @BeforeEach
    public void setup() {
        winningLotto = new WinningLotto(numbers, bonusNumber);
    }

    @Test
    public void equal() {
        assertThat(winningLotto).isEqualTo(new WinningLotto(numbers, bonusNumber));
    }
}
