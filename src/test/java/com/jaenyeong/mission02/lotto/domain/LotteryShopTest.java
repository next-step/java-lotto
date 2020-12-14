package com.jaenyeong.mission02.lotto.domain;

import com.jaenyeong.mission02.lotto.domain.lottery.LotteryGame;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("복권을 생산해, 판매하는 LotteryShop 클래스 테스트")
class LotteryShopTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 7, 20, 60})
    @DisplayName("Lottery 객체 리스트 생성 테스트")
    void createLotteryList(final int howManyToBuy) {
        final List<LotteryGame> lotteryGames = LotteryShop.buyAutomatically(howManyToBuy);

        assertEquals(lotteryGames.size(), howManyToBuy);
    }
}
