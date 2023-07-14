package view;

import domain.Count;
import domain.Lotto;
import domain.LottoNumber;
import domain.LottoResult;
import domain.Money;
import domain.Rank;
import domain.RateOfReturn;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    private OutputView() {
    }

    public static void printPurchaseCount(final List<Lotto> lottos, final Count manualPurchaseCount) {
        final Count autoPurchaseCount = new Count(lottos.size()).decreaseBy(manualPurchaseCount);
        System.out.println(
            "\n수동으로 " + manualPurchaseCount + "장, 자동으로 " + autoPurchaseCount.getValue() + "장을 구매했습니다.");
    }

    public static void printLottos(final List<Lotto> lottos) {
        lottos.forEach(OutputView::printLotto);
        System.out.println();
    }

    public static void printStatistic(final LottoResult lottoResult, final Money money) {
        System.out.println("당첨 통계");
        System.out.println("---------");

        Arrays.stream(Rank.values())
            .sorted(Comparator.reverseOrder())
            .filter(rank -> rank != Rank.NONE)
            .forEach(rank -> printEachResult(rank, lottoResult.countRank(rank)));

        printRateOfReturn(lottoResult, money);
    }

    private static void printLotto(final Lotto lotto) {
        final String content = lotto.getLottoNumbers().stream()
            .map(LottoNumber::getValue)
            .sorted()
            .map(String::valueOf)
            .collect(Collectors.joining(", ", "[", "]"));
        System.out.println(content);
    }

    private static void printEachResult(final Rank rank, final Count count) {
        final String result = String.format(
            "%d개 일치%s(%d원)- %d개",
            rank.getMatchLottoNumber(),
            rank.hasToCheckBonus() ? ", 보너스 볼 일치" : " ",
            rank.getPrize()
                .getValue(),
            count.getValue()
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
