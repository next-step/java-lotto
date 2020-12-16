package com.jaenyeong.mission02.lotto.domain;

import com.jaenyeong.mission02.lotto.domain.lottery.LotteryGame;

import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class LotteryShop {
    private LotteryShop() {
    }

    public static List<LotteryGame> buyAutomatically(final int howManyToBuy) {
        return Stream.generate(LotteryGame::ofAuto)
            .limit(howManyToBuy)
            .collect(toList());
    }

    public static List<LotteryGame> buyManually(final List<List<Integer>> givenNumbers) {
        return givenNumbers.stream()
            .map(LotteryGame::ofManual)
            .collect(toList());
    }
}
