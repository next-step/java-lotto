package view;

import domain.Lotto;
import domain.LottoCountManager;
import domain.LottoReport;

import java.util.List;

public class ResultView {
    public static void showBoughtLottos(List<Lotto> lottos) {
        StringBuilder sb = new StringBuilder();
        for (Lotto lotto : lottos) {
            sb.append(lotto.toString());
            sb.append("\n");
        }
        System.out.println(sb.toString()+"\n");
    }

    public static void howManyBoughtLotto(LottoCountManager lottoCountManager) {
        System.out.println(String.format("수동으로 %d장, 자동으로 %d개를 구매했습니다.",
                lottoCountManager.manualCount(),
                lottoCountManager.autoCount())
        );
    }

    public static void showResult(LottoReport lottoReport) {
        System.out.println("당첨 통계\n---------");
        showMatches(lottoReport);
        showRate(lottoReport);
    }

    private static void showMatches(LottoReport lottoReport) {
        StringBuilder sb = new StringBuilder();
        for (String match : lottoReport.getMatches()) {
            sb.append(match);
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    private static void showRate(LottoReport lottoReport) {
        System.out.println(lottoReport.getRate());
    }
}
