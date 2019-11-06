package lottery;

import java.text.MessageFormat;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import lottery.domain.Prize;

public class LottoResults {

    private static final String REPRESENT_PATTERN = "{0}개 일치 ({1}원)- {2}개\n";
    private final Map<Prize, Integer> totalResults = new EnumMap<>(Prize.class);

    public LottoResults(List<LottoResult> lottoResults) {
        calculateStatistics(lottoResults);
    }

    private void calculateStatistics(List<LottoResult> lottoResults) {
        Arrays.stream(Prize.values())
            .forEach(
                prize -> totalResults.put(prize, countNumberOfPrize(lottoResults, prize))
            );
    }

    private int countNumberOfPrize(List<LottoResult> lottoResults, Prize prize) {
        return (int) lottoResults.stream()
            .filter(lottoResult -> lottoResult.isPrize(prize))
            .count();
    }

    public double getEarningRate() {
        return sumOfWinMoney() / (double) purchasedAmount();
    }

    private int purchasedAmount() {
        return LottoConstants.TICKET_PRICE * totalResults.values()
                                                         .stream()
                                                         .reduce(0, Integer::sum);
    }

    private double sumOfWinMoney() {
        return Arrays.stream(Prize.values())
            .map(this::calculateWinMoney)
            .reduce(0, Integer::sum);
    }

    private int calculateWinMoney(Prize prize) {
        return totalResults.get(prize) * prize.getWinMoney();
    }

    @Override
    public String toString() {
        StringBuilder resultString = new StringBuilder();
        resultString.append("\n당첨 통계\n");
        resultString.append("---------\n");
        Arrays.stream(Prize.values())
            .filter(prize -> !Prize.isFail(prize))
            .forEach(
                prize -> resultString.append(MessageFormat.format(REPRESENT_PATTERN,
                    prize.getMatchedNumber(), prize.getWinMoney(), totalResults.get(prize))
                )
            );
        return resultString.toString();
    }
}
