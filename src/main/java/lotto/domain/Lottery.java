package lotto.domain;

import java.util.*;

public class Lottery {
    public static final int LOTTO_LENGTH = 6;
    private Set<Integer> lottery;

    public Lottery(Set<Integer> lotteryNumber) {
        this.lottery = generationLottery(lotteryNumber);
    }

    public Set<Integer> generationLottery(Set<Integer> random) {
        for(int i = 0; i < LOTTO_LENGTH ; i++) {
            this.lottery = random;
        }

        return this.lottery;
    }

    public int matchLottery(Set<Integer> winnerLottery) {
        int matchCount = 0;

        for (Integer number : winnerLottery) {
            matchCount = matchNumber(matchCount, number);
        }

        return matchCount;
    }

    public int matchNumber(int matchCount, int number) {
        if (this.lottery.contains(number)) {
            matchCount++;
        }

        return matchCount;
    }

    // 중복생성 테스트용
    public Set<Integer> getLottery() {
        return this.lottery;
    }

    @Override
    public String toString() {
        return String.valueOf(this.lottery);
    }
}

