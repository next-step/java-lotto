package step2.domain;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Numbers {
    private static final int MAX_SIZE = 6;
    private static final int RANDOM_NUMBER_ORIGIN = 1;
    private static final int RANDOM_NUMBER_BOUND = 46;

    private List<Integer> lotteryInfo;

    private Numbers(List<Integer> lotteryInfo) {
        this.lotteryInfo = lotteryInfo;
    }

    private static Numbers of(List<Integer> lotteryInfo) {
        return new Numbers(lotteryInfo);
    }

    static Numbers getRandomNos() {
        return getLottoNos(RANDOM_NUMBER_ORIGIN, RANDOM_NUMBER_BOUND);
    }

    static Numbers getLottoNos(int start, int end) {
        IntStream intStream = new Random().ints(start, end);
        return Numbers.of(intStream.distinct()
                                   .limit(MAX_SIZE)
                                   .sorted()
                                   .boxed()
                                   .collect(Collectors.toList()));
    }

    static Numbers convertStringToNo(String input) {
        String removingSpacesWinnersNo = input.replaceAll(" ", "");
        return Numbers.of(Arrays.stream(removingSpacesWinnersNo.split(","))
                                .map(Numbers::toInt)
                                .collect(Collectors.toList()));
    }

    static int toInt(String inputNumbers) {
        if (!StringUtils.isNumeric(inputNumbers)) {
            throw new IllegalArgumentException("숫자가 아닙니다.");
        }
        return Integer.parseInt(inputNumbers);
    }

    public List<Integer> getLotteryInfo() {
        return lotteryInfo;
    }

    @Override
    public String toString() {
        return this.lotteryInfo.stream().map(String::valueOf)
                               .collect(Collectors.joining(","));
    }
}
