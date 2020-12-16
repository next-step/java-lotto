package com.jaenyeong.mission02.lotto.domain;

import com.jaenyeong.mission02.lotto.domain.lottery.LotteryGame;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("복권 당첨번호를 나타내는 WinningNumbers 클래스 테스트")
class WinningNumbersTest {

    @Test
    @DisplayName("1등 테스트")
    void firstRankTest() {
        final List<Integer> givenNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        final LotteryGame buyGame = LotteryGame.ofManual(givenNumbers);
        final LotteryGame winningLottery = LotteryGame.ofManual(givenNumbers);

        assertEquals(winningLottery.checkWinTheLottery(buyGame), Rank.FIRST);
    }

    @Test
    @DisplayName("3등 테스트")
    void thirdRankTest() {
        final LotteryGame buyGame = LotteryGame.ofManual(Arrays.asList(1, 2, 3, 4, 5, 6));
        final LotteryGame winningLottery = LotteryGame.ofManual(Arrays.asList(1, 2, 3, 4, 5, 7));

        assertEquals(winningLottery.checkWinTheLottery(buyGame), Rank.THIRD);
    }

    @Test
    @DisplayName("4등 테스트")
    void fourthRankTest() {
        final LotteryGame buyGame = LotteryGame.ofManual(Arrays.asList(1, 2, 3, 4, 5, 6));
        final LotteryGame winningLottery = LotteryGame.ofManual(Arrays.asList(1, 2, 3, 4, 9, 7));

        assertEquals(winningLottery.checkWinTheLottery(buyGame), Rank.FOURTH);
    }

    @Test
    @DisplayName("5등 테스트")
    void fifthRankTest() {
        final LotteryGame buyGame = LotteryGame.ofManual(Arrays.asList(1, 2, 3, 4, 5, 6));
        final LotteryGame winningLottery = LotteryGame.ofManual(Arrays.asList(1, 2, 3, 14, 9, 7));

        assertEquals(winningLottery.checkWinTheLottery(buyGame), Rank.FIFTH);
    }

    @Test
    @DisplayName("꽝 테스트")
    void missRankTest() {
        final LotteryGame buyGame = LotteryGame.ofManual(Arrays.asList(1, 2, 3, 4, 5, 6));
        final LotteryGame winningLottery = LotteryGame.ofManual(Arrays.asList(11, 12, 13, 14, 15, 16));

        assertEquals(winningLottery.checkWinTheLottery(buyGame), Rank.MISS);
    }
}
