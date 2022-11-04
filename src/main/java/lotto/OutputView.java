package lotto;

import java.util.StringJoiner;

public class OutputView {
    public static void outputBuyLottoResult(Lottos manualLottos, Lottos autoLottos) {
        System.out.printf("수동으로 %d장, 자동으로 %d장을 구매했습니다.\n", manualLottos.getLottosSize(), autoLottos.getLottosSize());
        for (Lotto lotto : manualLottos.getLottos()) {
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            StringJoiner sj = new StringJoiner(", ");
            for (LottoNumber lottoNumber : lotto.getLotto()) {
                sj.add(String.valueOf(lottoNumber.getLottoNumber()));
            }
            sb.append(sj);
            sb.append("]");
            System.out.println(sb);
        }
        for (Lotto lotto : autoLottos.getLottos()) {
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            StringJoiner sj = new StringJoiner(", ");
            for (LottoNumber lottoNumber : lotto.getLotto()) {
                sj.add(String.valueOf(lottoNumber.getLottoNumber()));
            }
            sb.append(sj);
            sb.append("]");
            System.out.println(sb);
        }
        System.out.println();
    }

    public static void outputStatistics(Statistic statistic) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        for (Statistic.MatchingResult result : statistic.getMatching()) {
            Winning winning = result.getWinning();
            System.out.printf("%d개 일치", winning.getMatchCount());
            if(winning.isBonusBallUse()) {
                System.out.print(", 보너스볼 일치");
            }
            System.out.printf("(%d원) - %d개\n", winning.getPrize().getMoney(), result.getCount());
        }
        System.out.printf("총 수익률은 %.2f입니다.", statistic.getEarningRate());
    }


}
