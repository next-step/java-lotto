package lotto.domain;

import java.util.Set;

import static lotto.domain.LotteryNo.isEqual;

public class Lottery {
    public static final int LOTTO_LENGTH = 6;
    private Set<LotteryNo> lottery;

    public Lottery(Set<LotteryNo> lotteryNumber) {
        this.lottery = generationLottery(lotteryNumber);

        checkLotterySize(lotteryNumber);
    }

    private void checkLotterySize(Set<LotteryNo> lotteryNumber) {
        if (lotteryNumber.size() != LOTTO_LENGTH) {
           throw new IllegalArgumentException();
        }
    }

    public Set<LotteryNo> generationLottery(Set<LotteryNo> random) {
        for (int i = 0; i < LOTTO_LENGTH ; i++) {
            this.lottery = random;
        }

        return this.lottery;
    }

    public int matchLottery(Lottery winnerLottery) {
        int matchCount = 0;

        for (LotteryNo number : winnerLottery.lottery) {
            matchCount = matchNumber(matchCount, number);
        }

        return matchCount;
    }

    public int matchNumber(int matchCount, LotteryNo number) {
        if (contain(number)) {
            matchCount++;
        }

        return matchCount;
    }

    public boolean contain(LotteryNo number) {
        for (LotteryNo lotteryNo : this.lottery) {
            if(isEqual(number, lotteryNo)) {
                return true;
            }
        }

        return false;
    }

    public int getLotterySize() {
        return this.lottery.size();
    }

    @Override
    public String toString() {
        return String.valueOf(this.lottery);
    }
}

