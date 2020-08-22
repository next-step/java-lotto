package step2.domain;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lotto {
    private static final int MAX_SIZE = 6;
    private static final int RANDOM_NUMBER_ORIGIN = 1;
    private static final int RANDOM_NUMBER_BOUND = 46;

    private List<Integer> lotteryInfo;

    private Lotto(List<Integer> lotteryInfo) {
        this.lotteryInfo = lotteryInfo;
    }

    public static Lotto ofLotto() {
        List<Integer> lottoNumbers = getRandomNos();
        return new Lotto(lottoNumbers);
    }

    public static Lotto ofLottoByDesignatedRange(int start, int end) {
        List<Integer> lottoNumbers = getLottoNos(start, end);
        return new Lotto(lottoNumbers);
    }

    static List<Integer> getLottoNos(int start, int end) {
        IntStream intStream = new Random().ints(start, end);
        return intStream.distinct()
                .limit(MAX_SIZE)
                .sorted()
                .boxed()
                .collect(Collectors.toList());
    }

    static List<Integer> getRandomNos() {
        return getLottoNos(RANDOM_NUMBER_ORIGIN, RANDOM_NUMBER_BOUND);
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
