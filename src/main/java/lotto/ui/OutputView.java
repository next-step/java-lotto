package lotto.ui;

import lotto.domian.*;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    private static final String RECORD_RESULT_MESSAGE = "%d개 일치 (%d원) - %d개";
    private static final String RECORD_RESULT_MESSAGE_IF_SECOND = "%d개 일치, 보너스 볼 일치(%d원) - %d개";

    public static void showLottoBundle(LottoBundle bundle) {
        bundle.unfoldLottoBundle()
                .stream()
                .forEach(lotto -> {
                    showLottoNumber(lotto);
                });
        System.out.println();
    }

    public static void showRecord(Record record) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---------");
        printEachRank(record);
    }

    public static void showProfitRate(ProfitRate profitRate) {
        System.out.print("총 수익률은 ");
        System.out.printf("%.2f", profitRate.value());
        System.out.println("입니다.(기준이 1입니다. 1이하면 손해라는 의미)");
    }

    private static void printEachRank(Record record) {
        Arrays.stream(Rank.values())
                .filter(rank -> rank.getMatchingCount() >= 3)
                .sorted(Comparator.reverseOrder())
                .forEach(rank -> {
                    if (rank == Rank.SECOND) {
                        System.out.printf(RECORD_RESULT_MESSAGE_IF_SECOND, rank.getMatchingCount(), rank.getPrize(), record.getRecord().getOrDefault(rank, 0));
                        System.out.println();
                        return;
                    }
                    System.out.printf(RECORD_RESULT_MESSAGE, rank.getMatchingCount(), rank.getPrize(), record.getRecord().getOrDefault(rank, 0));
                    System.out.println();
                });
    }

    private static void showLottoNumber(Lotto lotto) {
        List<Integer> sortedNumbers = sort(lotto);
        printNumbers(sortedNumbers);
    }

    private static void printNumbers(List<Integer> sortedNumbers) {
        System.out.println(sortedNumbers
                .stream()
                .map(number -> String.valueOf(number))
                .collect(Collectors.toList())
                .stream()
                .collect(Collectors.joining(", ", "[", "]")));
    }

    private static List<Integer> sort(Lotto lotto) {
        return lotto.getLottoNumbers()
                .stream()
                .map(lottoNumber -> lottoNumber.getNumber())
                .sorted()
                .collect(Collectors.toList());
    }

}
