package view;

import domain.LottoCount;
import domain.Lotto;
import domain.LottoFormatter;
import domain.LottoResult;
import domain.Money;
import domain.Rank;
import domain.RateOfReturn;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class OutputView {

    private static final LottoFormatter lottoFormatter = new DefaultLottoFormatter();

    private OutputView() {
    }

    public static void printPurchaseCount(final List<Lotto> lottos,
        final LottoCount manualPurchaseCount) {
        final LottoCount autoPurchaseCount = new LottoCount(lottos.size()).decreaseBy(manualPurchaseCount);
        System.out.println(
            "\n수동으로 " + manualPurchaseCount.getValue() + "장, 자동으로 " + autoPurchaseCount.getValue()
                + "장을 구매했습니다.");
    }

    public static void printLottos(final List<Lotto> lottos) {
        lottos.stream()
            .map(lotto -> lotto.format(lottoFormatter))
            .forEach(System.out::println);
    }

    public static void printStatistic(final LottoResult lottoResult, final Money money) {
        System.out.println("\n당첨 통계");
        System.out.println("---------");

        Arrays.stream(Rank.values())
            .sorted(Comparator.reverseOrder())
            .filter(rank -> rank != Rank.NONE)
            .forEach(rank -> printEachResult(rank, lottoResult.countRank(rank)));

        printRateOfReturn(lottoResult, money);
    }

    private static void printEachResult(final Rank rank, final Long count) {
        final String result = String.format(
            "%d개 일치%s(%d원)- %d개",
            rank.getMatchLottoNumber(),
            rank.hasToCheckBonus() ? ", 보너스 볼 일치" : " ",
            rank.getPrize()
                .getValue(),
            count
        );
        System.out.println(result);
    }

    private static void printRateOfReturn(final LottoResult lottoResult, final Money money) {
        final RateOfReturn rateOfReturn = lottoResult.calculateRateOfReturn(money);

        final String result = String.format("총 수익률은 %.2f입니다.",
            Math.floor(rateOfReturn.getValue() * 100) / 100);
        System.out.println(result);
    }
}
