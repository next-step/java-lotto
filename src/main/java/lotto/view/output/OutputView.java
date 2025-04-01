package lotto.view.output;

import lotto.domain.PaymentHistory;
import lotto.domain.PaymentReceipt;
import lotto.domain.Quantity;
import lotto.domain.product.FinalResult;
import lotto.domain.product.LottoRank;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class OutputView {

    private static final String NUMBER_OUTPUT_DELIMITER = ", ";
    private static final String OUTPUT_PREFIX = "[";
    private static final String OUTPUT_SUFFIX = "]";

    public void printResult(FinalResult result, PaymentReceipt paid) {
        System.out.println("당첨 통계");
        System.out.println("---------");

        Arrays.stream(LottoRank.values())
                .filter(rank -> rank != LottoRank.NO_WIN)
                .sorted(Comparator.comparingInt(LottoRank::getMatchCount))
                .forEach(rank -> {
                    printMatchCount(result, rank);
                });

        System.out.printf("총 수익률은 %.2f입니다.\n", result.returnRate(paid));
    }

    private static void printMatchCount(FinalResult result, LottoRank rank) {
        String bonusInfo = rank == LottoRank.FIVE_BONUS ? ", 보너스 볼 일치" : "";
        System.out.printf("%d개 일치%s (%d원) - %d개\n",
                rank.getMatchCount(),
                bonusInfo,
                rank.getPrize(),
                result.getResult().getOrDefault(rank, 0));
    }

    @Deprecated
    public void userPurchased(Integer count) {
        System.out.println(count + "개를 구매 했습니다.");
    }

    public void printAutoLottery(PaymentHistory tickets) {
        System.out.println(autoLotteryToString(tickets.autoLotteryTickets()));
    }

    public String autoLotteryToString(List<Set<Integer>> lotteryTickets) {
        return lotteryTickets.stream()
                .map(ticket -> ticket.stream()
                        .sorted()
                        .map(String::valueOf)
                        .collect(Collectors.joining(NUMBER_OUTPUT_DELIMITER, OUTPUT_PREFIX, OUTPUT_SUFFIX)))
                .collect(Collectors.joining("\n"));
    }

    public void printUserReceipt(Quantity totalQuantity, Quantity manualQuantity) {
        System.out.printf("수동으로 %d장, 자동으로 %d개를 구매했습니다.", manualQuantity.value(), totalQuantity.minus(manualQuantity).value());
    }
}
