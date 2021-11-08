package lotto.views;

import lotto.domains.Lotto;
import lotto.domains.LottoResult;
import lotto.domains.LottoResults;
import lotto.domains.Lottos;

public class ResultView {

    public static void printLottoCount(int lottosCnt) {
        StringBuilder sb = new StringBuilder();
        sb.append(lottosCnt);
        sb.append("개를 구매했습니다.");

        System.out.println(sb.toString());
    }

    public static void printLottos(Lottos lottos) {
        for (Lotto lotto : lottos.lottos()) {
            System.out.println(lotto.numbers());
        }
    }

    public static void printLottoResult(LottoResults lottoResults) {
        System.out.println("당첨 통계");
        System.out.println("---------");

        for (LottoResult lottoResult : lottoResults.getLottoResults()) {
            System.out.println(lottoResult.detailedInfo());
        }
    }

    public static void printProfitRate(Double profitRate) {
        StringBuilder sb = new StringBuilder();
        sb.append("총 수익률은 ");
        sb.append(profitRate);
        sb.append("입니다.");

        if (profitRate < 1) {
            sb.append("(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
        }

        System.out.println(sb.toString());
    }

}
