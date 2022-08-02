package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AutoLotteryGameTest {

    @DisplayName("랜덤하게 로또 게임 생성")
    @Test
    void construct_auto() {
        AutoLotteryGame autoLotteryGame = new AutoLotteryGame();
        assertThat(autoLotteryGame.getLotteries()).hasSize(6);
    }
}
