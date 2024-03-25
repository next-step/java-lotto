package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoResult {

    private final Map<LottoPrize, Long> result;

    public LottoResult(List<Lotto> lottos, List<Integer> answerSheet) {
        this.result = LottoMatcher.matchLottoToPrize(lottos, answerSheet);
    }

    private int calculateTotalEarnings() {
        return result.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getTotalPrice(entry.getValue()))
                .sum();
    }

    public double getWinningPercent(PrizeRateStrategy rateStrategy ,int lottoPrice) {
        int spendMoney = lottoPrice * result.size();
        return rateStrategy.getRate(calculateTotalEarnings(),spendMoney);
    }

    public List<String> getWinningWords() {
        return Arrays.stream(LottoPrize.values())
                .filter(prize -> !prize.equals(LottoPrize.NONE))
                .map(prize -> prize.formatPrizeText(result.getOrDefault(prize,0L)))
                .collect(Collectors.toList());
    }


}
