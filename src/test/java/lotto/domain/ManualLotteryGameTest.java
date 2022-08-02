package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class ManualLotteryGameTest {

    @DisplayName("수동 번호를 통해 로또 게임 생성")
    @Test
    void construct_manual() {
        ManualLotteryGame manualLotteryGame = new ManualLotteryGame("1,3,2,4,6,5");
        assertAll(
                () -> assertThat(manualLotteryGame.getLotteries().get(0)).isEqualTo(LotteryNumber.of(1)),
                () -> assertThat(manualLotteryGame.getLotteries().get(1)).isEqualTo(LotteryNumber.of(2)),
                () -> assertThat(manualLotteryGame.getLotteries().get(2)).isEqualTo(LotteryNumber.of(3)),
                () -> assertThat(manualLotteryGame.getLotteries().get(3)).isEqualTo(LotteryNumber.of(4)),
                () -> assertThat(manualLotteryGame.getLotteries().get(4)).isEqualTo(LotteryNumber.of(5)),
                () -> assertThat(manualLotteryGame.getLotteries().get(5)).isEqualTo(LotteryNumber.of(6))
        );
    }
}
