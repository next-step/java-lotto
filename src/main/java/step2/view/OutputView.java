package step2.view;

import step2.domain.entity.Lottos;
import step2.domain.entity.LottoRank;
import step2.domain.vo.LottoPrize;

public class OutputView {

    private OutputView() {
    }

    public static void printLottos(Lottos lottos) {
        final var manualQuantity = lottos.getManualLottoQuantity();
        final var autoQuantity = lottos.getAutoLottoQuantity();

        System.out.println(System.lineSeparator() + "수동으로 " + manualQuantity + "장, 자동으로 " + autoQuantity + "개를 구매했습니다.");
        lottos.getLottos().forEach(System.out::println);
    }

    public static void printWinnerStatistics(Lottos lottos, LottoRank lottoRank) {
        System.out.println(System.lineSeparator() + "당첨 통계");
        System.out.println("---------");

        printPrizeCount(lottoRank);

        System.out.println("총 수익률은 " + lottoRank.getTotalRate(lottos.size()) + "입니다.");
    }

    private static void printPrizeCount(LottoRank lottoRank) {
        final var prizes = LottoPrize.values();
        final var fourthIndex = prizes.length - 2;
        final var firstIndex = 0;

        // 낙첨을 제외한 3개 일치(4등) ~ 6개 일치(1등) 까지 출력
        for (int i = fourthIndex; i >= firstIndex; i--) {
            final var prize = prizes[i];
            final var count = lottoRank.getLottoRankCount(prize);
            System.out.println(prize.getDescription() + " - " + count + "개");
        }
    }
}
