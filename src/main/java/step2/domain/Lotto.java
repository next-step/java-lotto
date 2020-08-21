package step2.domain;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lotto {
    private static final int MAX_SIZE = 6;
    private static final int RANDOM_NUMBER_ORIGIN = 1;
    private static final int RANDOM_NUMBER_BOUND = 46;

    private String lotteryPaper;
    private List<Integer> lotteryInfo;

    private Lotto(String lotteryPaper, List<Integer> lotteryInfo) {
        this.lotteryPaper = lotteryPaper;
        this.lotteryInfo = lotteryInfo;
    }

    public static Lotto ofLotto() {
        List<Integer> lottoNumbers = getRandomNos();
        return new Lotto(getLottoIssuance(lottoNumbers), lottoNumbers);
    }

    public static Lotto ofLottoByDesignatedRange(int start, int end) {
        List<Integer> lottoNumbers = getLoTToNos(start, end);
        return new Lotto(getLottoIssuance(lottoNumbers), lottoNumbers);
    }

    static List<Integer> getLoTToNos(int start, int end) {
        IntStream intStream = new Random().ints(start, end);
        return intStream.distinct()
                .limit(MAX_SIZE)
                .sorted()
                .boxed()
                .collect(Collectors.toList());
    }

    static List<Integer> getRandomNos() {
        return getLoTToNos(RANDOM_NUMBER_ORIGIN, RANDOM_NUMBER_BOUND);
    }

    static String getLottoIssuance(List<Integer> numbers) {
        return numbers.stream().map(String::valueOf)
                .collect(Collectors.joining(","));
    }

    public String getLotteryPaper() {
        return lotteryPaper;
    }

    public List<Integer> getLotteryInfo() {
        return lotteryInfo;
    }
}
