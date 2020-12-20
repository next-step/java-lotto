package step2.view;

import step2.domain.LottoRequest;
import step2.domain.Rank;
import step2.domain.lotto.LottoNumbers;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.*;
import static step2.domain.Rank.*;

public class ResultView {

    private static void printMessage(String message) {
        System.out.println(message);
    }

    private static void printResult(Rank rank, long countOfMatch, long winningMoney, Long total) {
        String addition = " ";
        if (rank == SECOND) {
            addition = ", 보너스 볼 일치";
        }
        System.out.println(countOfMatch + "개 일치" + addition + "(" + winningMoney + "원) - " + total + "개");
    }

    public static void printLotto(List<LottoNumbers> lottoNumbers, String delimiter) {
        printMessage(lottoNumbers.size() + "개를 구매했습니다.");
        for (LottoNumbers numbers : lottoNumbers) {
            printNumbers(numbers.getLottoNumbers(), delimiter);
        }
    }

    private static void printNumbers(List<Integer> numbers, String delimiter) {
        String result = numbers.stream()
                .map(String::valueOf)
                .collect(joining(delimiter));
        printMessage("[" + result + "]");
    }

    public static void printWinLotto(Map<Rank, Long> rankResult, LottoRequest lottoRequest) {
        printMessage("당첨 통계");
        printMessage("--------");
        setRankData(rankResult);
        rankResult.entrySet()
                .stream()
                .sorted(Comparator.comparingLong(entry -> entry.getKey().getWinningMoney()))
                .forEach(entry -> printResult(entry.getKey(), entry.getKey().getCountOfMatch(), entry.getKey().getWinningMoney(), entry.getValue()));
        printMargin(lottoRequest, rankResult);
    }

    private static void setRankData(Map<Rank, Long> result) {
        Arrays.stream(values())
                .filter(r -> r != MISS)
                .forEach(rank -> result.computeIfAbsent(rank, r -> 0L));
    }

    private static void printMargin(LottoRequest lottoRequest, Map<Rank, Long> rankResult) {
        double income = rankResult.entrySet()
                .stream()
                .mapToLong(entry -> entry.getKey().getWinningMoney() * entry.getValue())
                .sum();

        double incomeRate = (income / lottoRequest.getPurchaseMoney()) * 100;
        printMessage("총 수익률은 " + incomeRate + "입니다.");
    }
}
