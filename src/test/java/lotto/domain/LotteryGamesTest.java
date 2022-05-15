package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LotteryGamesTest {

    @DisplayName("로또 게임 생성")
    @Test
    void create() {
        LotteryGames lotteryGames = new LotteryGames(10);
        assertThat(lotteryGames.getLotteryGames()).hasSize(10);
    }
}
