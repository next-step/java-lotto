package step2.domain;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoMatchResult {

    public static final int LOTTO_MATCHED_START_RANGE = 3;
    public static final int LOTTO_MATCHED_END_RANGE = 7;
    public static final int LOTTO_MATCHED_DEFAULT = 0;
    public static final int LOTTO_CARCULATE_DIVISION = 100;

    private final Map<Integer, Long> matchResult;
    private final int price;

    public LottoMatchResult(int price, Map<Integer, Long> matchResult) {
        this.price = price;
        this.matchResult = matchResult;
    }

    public List<String> resultMessages() {
        return IntStream.range(LOTTO_MATCHED_START_RANGE, LOTTO_MATCHED_END_RANGE)
                .mapToObj(index -> getMatchedMessage(index))
                .collect(Collectors.toList());
    }

    private String getMatchedMessage(int index) {
        if (matchResult.get(index) != null) {
            return LottoMatchResultCount.of(index).getMatchResultsMessage(matchResult.get(index));
        }
        return LottoMatchResultCount.of(index).getMatchResultsMessage(LOTTO_MATCHED_DEFAULT);
    }

    public double resultBenefit() {
        double sum = matchResult.entrySet()
                .stream()
                .mapToLong(matchResult ->
                        LottoMatchResultCount.of(matchResult.getKey())
                                .getBenefit(matchResult.getValue()))
                .sum();

        return getCarculatorMoney(price, sum);
    }

    private double getCarculatorMoney(double price, double sum) {
        double result = (sum / price) * LOTTO_CARCULATE_DIVISION;
        return Math.floor(result) / LOTTO_CARCULATE_DIVISION;
    }
}
