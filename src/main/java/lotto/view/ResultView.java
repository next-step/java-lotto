package lotto.view;

import lotto.Lotto;
import lotto.Lottos;

import java.util.List;

public abstract class ResultView {

    private final static String COUNT_OF_PURCHASES_SUFFIX = "개를 구매했습니다.";

    private ResultView() {
    }

    public static void printLottos(final List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getLottoNumber().toString());
        }
    }

    public static void printCountOfPurchases(final int purchase) {
        System.out.println(purchase + COUNT_OF_PURCHASES_SUFFIX);
    }

    public static void newLine() {
        System.out.println();
    }

    @SuppressWarnings("StringBufferReplaceableByString")
    public static String printAnalysisLottoResult(final List<Lotto> lottos, final double rate) {
        final StringBuilder sb = new StringBuilder();
        sb.append("당첨 통계\n").append("---------\n");
        sb.append("3개 일치 (5000원)- ").append(Lottos.filter(lottos, 3).size()).append("개\n");
        sb.append("4개 일치 (50000원)- ").append(Lottos.filter(lottos, 4).size()).append("개\n");
        sb.append("5개 일치 (1500000원)- ").append(Lottos.filter(lottos, 5).size()).append("개\n");
        sb.append("6개 일치 (2000000000원)- ").append(Lottos.filter(lottos, 6).size()).append("개\n");
        sb.append("총 수익률은 ").append(rate).append("입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
        return sb.toString();
    }


}
