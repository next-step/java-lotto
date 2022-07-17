package lotto.domain;

import lotto.interfaces.LotteryGame;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertAll;

public class LotteryGamesTest {

    @DisplayName("자동 방식으로 로또 게임 구매")
    @Test
    void construct_auto() {
        LotteryGames lotteryGames = new LotteryGames(10000);
        assertThat(lotteryGames.getLotteryGameList()).hasSize(10);
    }

    @DisplayName("수동 방식으로 로또 게임 구매")
    @ParameterizedTest
    @ValueSource(ints = {0,1})
    void construct_manual(int index) {
        List<LotteryGame> manualLotteryGames = new ArrayList<>();
        manualLotteryGames.add(new ManualLotteryGame("1,2,3,4,5,6"));
        manualLotteryGames.add(new ManualLotteryGame("2,3,4,5,6,7"));

        LotteryGames lotteryGames = new LotteryGames(2000, manualLotteryGames);
        assertThat(lotteryGames.getLotteryGameList()).hasSize(2);
        assertThat(lotteryGames.getLotteryGameList().get(index)).isInstanceOf(ManualLotteryGame.class);
    }

    @DisplayName("수동, 자동 방식 혼합하여 로또 게임 구매")
    @Test
    void construct_autoWithManual() {
        List<LotteryGame> manualLotteryGames = new ArrayList<>();
        manualLotteryGames.add(new ManualLotteryGame("1,2,3,4,5,6"));
        manualLotteryGames.add(new ManualLotteryGame("2,3,4,5,6,7"));

        LotteryGames lotteryGames = new LotteryGames(10000, manualLotteryGames);
        assertThat(lotteryGames.getLotteryGameList()).hasSize(10);

        assertAll(
                () -> assertThat(lotteryGames.getLotteryGameList().get(0)).isInstanceOf(ManualLotteryGame.class),
                () -> assertThat(lotteryGames.getLotteryGameList().get(1)).isInstanceOf(ManualLotteryGame.class),
                () -> assertThat(lotteryGames.getLotteryGameList().get(2)).isInstanceOf(AutoLotteryGame.class),
                () -> assertThat(lotteryGames.getLotteryGameList().get(3)).isInstanceOf(AutoLotteryGame.class),
                () -> assertThat(lotteryGames.getLotteryGameList().get(4)).isInstanceOf(AutoLotteryGame.class),
                () -> assertThat(lotteryGames.getLotteryGameList().get(5)).isInstanceOf(AutoLotteryGame.class),
                () -> assertThat(lotteryGames.getLotteryGameList().get(6)).isInstanceOf(AutoLotteryGame.class),
                () -> assertThat(lotteryGames.getLotteryGameList().get(7)).isInstanceOf(AutoLotteryGame.class),
                () -> assertThat(lotteryGames.getLotteryGameList().get(8)).isInstanceOf(AutoLotteryGame.class),
                () -> assertThat(lotteryGames.getLotteryGameList().get(9)).isInstanceOf(AutoLotteryGame.class)
        );
    }

    @DisplayName("구매금액을 1000원보다 적게 입력하였을 때")
    @Test
    void construct_lowerThan1000() {
        assertThatIllegalArgumentException().isThrownBy(() -> new LotteryGames(800))
                .withMessageContaining("로또 구매를 위해서는 천원 이상 입력해야 합니다.");
    }

    @DisplayName("구매금액을 1000원 단위가 아닌 값을 입력하였을 때 (예, 1999원)")
    @Test
    void construct_invalidPrice() {
        assertThatIllegalArgumentException().isThrownBy(() -> new LotteryGames(1999))
                .withMessageContaining("천원 단위로 입력해주세요.");
    }


}
