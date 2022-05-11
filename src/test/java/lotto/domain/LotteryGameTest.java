package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LotteryGameTest {
    private static final int START_NUMBER = 1;
    private static final int END_NUMBER = 45;

    // lotto 게임 생성 (list 내부 size, 내부 데이터가 45 이하인지 확인
    @DisplayName("생성된 list size 확인")
    @Test
    void create_lottoSize() {
        LotteryGame lotteryGame = new LotteryGame();
        assertThat(lotteryGame.create().getLotteries()).hasSize(6);
    }

    @DisplayName("생성된 로또 게임 번호 유효성 확인")
    @Test
    void create_validateNumber() {
        LotteryGame lotteryGame = new LotteryGame();
        List<Integer> lottery = lotteryGame.create().getLotteries();
        for (Integer number : lottery) {
            assertThat(number).isBetween(START_NUMBER, END_NUMBER);
        }
    }
}
