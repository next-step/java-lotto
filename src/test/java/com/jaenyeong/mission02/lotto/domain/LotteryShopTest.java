package com.jaenyeong.mission02.lotto.domain;

import com.jaenyeong.mission02.lotto.domain.lottery.LotteryGame;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("복권을 생산해, 판매하는 LotteryShop 클래스 테스트")
class LotteryShopTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 7, 20, 60})
    @DisplayName("Lottery 자동 생성 테스트")
    void createLotteryListByAuto(final int howManyToBuy) {
        final List<LotteryGame> lotteryGames = LotteryShop.buyAutomatically(howManyToBuy);

        assertEquals(lotteryGames.size(), howManyToBuy);
    }

    @Test
    @DisplayName("Lottery 수동 생성 테스트")
    void createLotteryListByManual() {
        final List<List<Integer>> givenNumbers = new ArrayList<>();
        givenNumbers.add(Arrays.asList(1, 2, 3, 4, 5, 6));
        givenNumbers.add(Arrays.asList(1, 2, 3, 4, 5, 6));
        givenNumbers.add(Arrays.asList(1, 2, 3, 4, 5, 6));
        givenNumbers.add(Arrays.asList(1, 2, 3, 4, 5, 6));
        givenNumbers.add(Arrays.asList(1, 2, 3, 4, 5, 6));

        final List<LotteryGame> lotteryGames = LotteryShop.buyManually(givenNumbers);

        assertEquals(lotteryGames.size(), 5);
    }
}
