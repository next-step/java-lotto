package view;

import domain.Lotto;
import domain.LottoNumber;
import domain.LottoResult;
import domain.Rank;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    public static void printLottosSize(final List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
    }

    public static void printLottos(final List<Lotto> lottos) {
        lottos.forEach(OutputView::printLotto);
        System.out.println();
    }

    private static void printLotto(final Lotto lotto) {
        final String content = lotto.getLottoNumbers().stream()
                .map(LottoNumber::getValue)
                .sorted()
                .map(String::valueOf)
                .collect(Collectors.joining(", ", "[", "]"));
        System.out.println(content);
    }

    public static void printStatistic(final LottoResult lottoResult, final long money) {
        System.out.println("당첨 통계");
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
                rank.containsBonus() ? ", 보너스 볼 일치" : " ",
                rank.getPrize(),
                count
        );
        System.out.println(result);
    }

    private static void printRateOfReturn(final LottoResult lottoResult, final long money) {
        final double rateOfReturn = lottoResult.calculateRateOfReturn(money);

        final String result = String.format("총 수익률은 %.2f입니다.", Math.floor(rateOfReturn * 100) / 100);
        System.out.println(result);
    }
}
