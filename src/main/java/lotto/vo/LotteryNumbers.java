package lotto.vo;

import java.util.List;
import java.util.stream.Collectors;

public class LotteryNumbers {
    public static final String FORMAT_COMMA = ",";
    private static final String FORMAT_PREFIX_BRACKET = "[";
    private static final String FORMAT_SUFFIX_BRACKET = "]";
    private List<LotteryNumber> lotteryNumbers;

    public LotteryNumbers(List<LotteryNumber> lotteryNumbers) {
        this.lotteryNumbers = lotteryNumbers;
    }

    public String printLottoNumber() {
        return lotteryNumbers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(FORMAT_COMMA, FORMAT_PREFIX_BRACKET, FORMAT_SUFFIX_BRACKET));
    }

    public int lotteryNumbersCount(){
        return lotteryNumbers.size();
    }
}
