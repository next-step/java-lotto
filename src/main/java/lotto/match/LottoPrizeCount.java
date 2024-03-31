package lotto.match;

import lotto.prize.LottoPrize;

import java.util.Objects;

public class LottoPrizeCount {
    private final LottoPrize lottoPrize;
    private final long count;


    public LottoPrizeCount(LottoPrize lottoPrize, long count) {
        this.lottoPrize = lottoPrize;
        this.count = count;
    }

    public int getTotalMoney() {
        return lottoPrize.getTotalPrice(count);
    }

    public boolean isLegal(){
        return !lottoPrize.equals(LottoPrize.NONE);
    }

    public long getCount(){
        return count;
    }

    public Integer getCorrectNumber(){
        return lottoPrize.getCorrectNumber();
    }

    public Integer getPrize(){
        return lottoPrize.getPrize();
    }

    public boolean hasBonus(){
        return lottoPrize.getIsBonus();
    }


    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        LottoPrizeCount that = (LottoPrizeCount) object;
        return count == that.count && lottoPrize == that.lottoPrize;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoPrize, count);
    }
}