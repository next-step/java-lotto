package lotto.vo;

import lotto.utils.Const;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class LotteryNumber {
    private Set<Integer> lotteryNumber;

    public LotteryNumber(Set<Integer> lotteryNumber) {
        if (lotteryNumber.size() < Const.LOTTERY_NUMBER)
            throw new IllegalArgumentException();
        this.lotteryNumber = lotteryNumber;
    }

    static LotteryNumber toObject(Set<Integer> integers) {
        return new LotteryNumber(integers);
    }

    public String toString() {
        List<Integer> convertLotteryNumber = new ArrayList<>(lotteryNumber);
        Collections.sort(convertLotteryNumber);
        return convertLotteryNumber
                .stream()
                .map(String::valueOf)
                .collect(Collectors.joining(Const.FORMAT_COMMA, Const.FORMAT_PREFIX_BRACKET, Const.FORMAT_SUFFIX_BRACKET));
    }
}
