package com.jaenyeong.mission02.lotto.domain;

import com.jaenyeong.mission02.lotto.domain.lottery.LotteryGame;

import java.util.ArrayList;
import java.util.List;

public class LotteryShop {
    private LotteryShop() {
    }

    public static List<LotteryGame> buyAutomatically(final int howManyToBuy) {
        final List<LotteryGame> games = new ArrayList<>();

        for (int i = 0; i < howManyToBuy; i++) {
            games.add(LotteryGame.ofAuto());
        }

        return games;
    }
}
