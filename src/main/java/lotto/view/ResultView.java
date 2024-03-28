package lotto.view;

import lotto.model.Lotto;
import lotto.model.LottoRank;
import lotto.model.LottoSale;

import java.util.List;
import java.util.Map;

public class ResultView {

    public static void printSaleResult(LottoSale lottoSale, int saleCount) {
        printSaleCountResult(saleCount);
        printSaleLottoResult(lottoSale);
    }

    public static void printSaleCountResult(int result) {
        System.out.println(result + "개를 구매했습니다.");
    }

    private static void printSaleLottoResult(LottoSale lottoSale) {
        List<Lotto> lottos = lottoSale.getLottos();

        for (Lotto lotto : lottos) {
            System.out.println(lotto.getLotto().toString());
        }
    }

    public static void printWinningStatisticsResult(Map<Integer, Integer> winLottos, float revenueRatio) {
        System.out.println("\n당첨 통계\n------------------------");
        printWinningResult(winLottos);
        printRevenueResult(revenueRatio);
    }

    private static void printWinningResult(Map<Integer, Integer> lottoResult) {
        for (Integer key : lottoResult.keySet()) {
            System.out.println(getPriceResult(key, lottoResult.get(key)));
        }
    }

    private static String getPriceResult(int matchCount, int winnigsCount) {
        String rankCheck = LottoRank.getRank(matchCount);

        if (rankCheck == null) {
            return null;
        }

        return String.format("[%s] %d개 일치 (%d원) - %d개",
                LottoRank.getRank(matchCount), matchCount, LottoRank.getPrice(matchCount), winnigsCount);

    }

    private static void printRevenueResult(float revenue) {
        StringBuilder sb = new StringBuilder();

        if (revenue == 0) {
            System.out.println(sb.append("\n총 수익률은 0 입니다.\n"));
            return;
        }

        System.out.println(sb.append(String.format("\n총 수익률은 %.2f 입니다.\n", revenue)));
    }
}
