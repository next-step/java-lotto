package lottery;

import java.text.MessageFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import lottery.domain.Prize;

public class LottoResults {

    private static final String REPRESENT_PATTERN = "{0}개 일치{1}({2}원)- {3}개\n";
    private Map<Prize, Integer> totalResults;

    public LottoResults(List<LottoResult> lottoResults) {
        calculateStatistics(lottoResults);
    }

    private void calculateStatistics(List<LottoResult> lottoResults) {
        this.totalResults = Arrays.stream(Prize.values())
            .collect(Collectors.toMap(Function.identity(), prize -> countNumberOfPrize(lottoResults, prize)));
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

    private String getBonusMessage(Prize prize) {
        if (prize.equals(Prize.SECOND)) {
            return ", 보너스 볼 일치";
        }
        return " ";
    }

    private void constructResultStatistics(StringBuilder resultString, Prize prize) {
        resultString.append(getFormattedResult(prize));
    }

    private String getFormattedResult(Prize prize) {
        return MessageFormat.format(REPRESENT_PATTERN,
            prize.getMatchedNumber(), getBonusMessage(prize), prize.getWinMoney(), totalResults.get(prize));
    }

    @Override
    public String toString() {
        return "\n당첨 통계\n"
             + "---------\n"
             + Arrays.stream(Prize.values())
                     .filter(prize -> !Prize.isFail(prize))
                     .collect(StringBuilder::new, this::constructResultStatistics, StringBuilder::append).toString();
    }
}
