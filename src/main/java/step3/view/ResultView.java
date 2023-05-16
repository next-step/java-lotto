package step3.view;

import step3.domain.Rank;
import step3.domain.LottosTotalResult;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ResultView {
    public static void printStartOfResult() {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---------");
    }

    public static void printTotalResult(LottosTotalResult lottosResult, int purchasePrice) {
        printStartOfResult();
        List<Rank> results = Arrays.stream(Rank.values())
                .sorted(Comparator.comparing(result -> result.winningPrice))
                .collect(Collectors.toList());
        for (Rank result : results) {
            printEachResult(result, lottosResult.get(result));
        }
        printRateOfReturn(lottosResult.getRateOfReturn(purchasePrice));
    }

    public static void printEachResult(Rank result, int numberOfMatched) {
        if (result.equals(Rank.MISS)) {
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(result.numbersToBeMatched);
        stringBuilder.append("개 일치");
        if (result.equals(Rank.SECOND)) {
            stringBuilder.append(", 보너스 볼 일치");
        }
        stringBuilder.append("(");
        stringBuilder.append(result.winningPrice);
        stringBuilder.append(")");
        stringBuilder.append(" - ");
        stringBuilder.append(numberOfMatched);
        stringBuilder.append("개");
        String view = stringBuilder.toString();
        System.out.println(view);
    }

    public static void printRateOfReturn(double rateOfReturn) {
        System.out.printf("총 수익률은 %.2f입니다.", rateOfReturn);
    }
}
