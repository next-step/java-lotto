package step2.view;

import step2.domain.entity.Lottos;
import step2.domain.vo.LottoPrize;

import java.util.List;

public class OutputView {

    private OutputView() {
    }

    public static void printLottoks(Lottos lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");

        lottos.getLottos().forEach(System.out::println);
    }

    public static void printWinnerStatistics(Lottos lottos, List<LottoPrize> lottoPrizes) {
        System.out.println(System.lineSeparator() + "당첨 통계");
        System.out.println("---------");

        printPrizeCount(lottoPrizes);

        System.out.println("총 수익률은 " + lottos.getTotalRate(lottoPrizes) + "입니다.");
    }

    private static void printPrizeCount(List<LottoPrize> lottoPrizes) {
        final var prizes = LottoPrize.values();
        final var fourthIndex = prizes.length - 2;
        final var firstIndex = 0;

        // 낙첨을 제외한 3개 일치(4등) ~ 6개 일치(1등) 까지 출력
        for (int i = fourthIndex; i >= firstIndex; i--) {
            final var prize = prizes[i];
            final var count = Lottos.getLottoRankCount(prize, lottoPrizes);
            System.out.println(prize.getDescription() + " - " + count + "개");
        }
    }
}
