package lotto.view;

import lotto.domain.numbers.LottoNumber;
import lotto.domain.numbers.LottoTicket;
import lotto.domain.MatchPrize;
import lotto.domain.Money;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class OutputView {

    public static void printLottoTickets(List<LottoTicket> lottoTickets) {
        System.out.println(lottoTickets.size() + "개를 구매했습니다.");
        lottoTickets.forEach(lottoTicket -> System.out.println(lottoNumbersToString(lottoTicket.getLottoNumbers())));
    }

    public static void printResults(Map<MatchPrize, Integer> lottoResults, Money money) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("당첨 통계\n").append("---------\n");

        Arrays.stream(MatchPrize.values())
                .filter(matchPrize -> matchPrize != MatchPrize.ZERO)
                .forEach(matchPrize -> {
                    stringBuilder.append(matchPrize.getMatchCount()).append("개 일치 (");
                    stringBuilder.append(matchPrize.getMoney()).append(")- ");
                    stringBuilder.append(lottoResults.get(matchPrize)).append("개\n");
                });
        System.out.println(stringBuilder.toString());

        printYield(lottoResults, money);
    }

    private static String lottoNumbersToString(List<LottoNumber> lottoNumbers) {
        return Arrays.toString(lottoNumbers.stream()
                .mapToInt(LottoNumber::getValue)
                .toArray());
    }

    private static void printYield(Map<MatchPrize, Integer> lottoResults, Money money) {
        long sum = Arrays.stream(MatchPrize.values())
                .mapToLong(matchPrize -> matchPrize.getMoney() * lottoResults.get(matchPrize))
                .sum();

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("총 수익률은 ");
        stringBuilder.append(money.calculateYield(sum));
        stringBuilder.append("입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
        System.out.println(stringBuilder.toString());
    }
}
