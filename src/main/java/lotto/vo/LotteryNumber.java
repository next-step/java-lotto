package lotto.vo;

import lotto.utils.Const;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class LotteryNumber {
    private List<Integer> lotteryNumber;

    public LotteryNumber(Set<Integer> lotteryNumber) {
        if (lotteryNumber.size() < Const.LOTTERY_NUMBER)
            throw new IllegalArgumentException();
        this.lotteryNumber = convertLotteryNumber(lotteryNumber);
    }

    static LotteryNumber toObject(Set<Integer> integers) {
        return new LotteryNumber(integers);
    }

    public String toString() {
        return lotteryNumber
                .stream()
                .map(String::valueOf)
                .collect(Collectors.joining(Const.FORMAT_COMMA, Const.FORMAT_PREFIX_BRACKET, Const.FORMAT_SUFFIX_BRACKET));
    }

    private List<Integer> convertLotteryNumber(Set<Integer> lotteryNumber) {
        List<Integer> convertLotteryNumber = new ArrayList<>(lotteryNumber);
        Collections.sort(convertLotteryNumber);
        return convertLotteryNumber;
    }

    public int containsCount(LotteryNumber userLotto) {
        int count = Const.INITIAL_NUMBER;
        for (Integer userNumber : userLotto.lotteryNumber) {
            if (lotteryNumber.contains(userNumber)) {
                count += Const.ADD_NUMBER;
            }
        }
        return count;
    }

    public Rank match(LotteryNumber userLotto) {
        int matchCount = containsCount(userLotto);
        return Rank.valueOf(matchCount);
    }
}
