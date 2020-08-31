package step2.domain;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumbers {
    private static final int MAX_SIZE = 6;
    private static final int RANDOM_NUMBER_ORIGIN = 1;
    private static final int RANDOM_NUMBER_BOUND = 46;

    private List<Integer> lotteryInfo;

    private LottoNumbers(List<Integer> lotteryInfo) {
        this.lotteryInfo = lotteryInfo;
    }

    private static LottoNumbers of(List<Integer> lotteryInfo) {
        return new LottoNumbers(lotteryInfo);
    }

    static LottoNumbers getRandomNos() {
        return getLottoNos(RANDOM_NUMBER_ORIGIN, RANDOM_NUMBER_BOUND);
    }

    static LottoNumbers getLottoNos(int start, int end) {
        IntStream intStream = new Random().ints(start, end);
        return LottoNumbers.of(intStream.distinct()
                                        .limit(MAX_SIZE)
                                        .sorted()
                                        .boxed()
                                        .collect(Collectors.toList()));
    }

    static LottoNumbers convertStringToNo(String input) {
        String removingSpacesWinnersNo = input.replaceAll(" ", "");
        return LottoNumbers.of(Arrays.stream(removingSpacesWinnersNo.split(","))
                                     .map(LottoNumbers::toInt)
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
