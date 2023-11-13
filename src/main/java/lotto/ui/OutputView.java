package lotto.ui;

import lotto.domain.LottoWinResult;
import lotto.domain.Lottos;

import java.util.List;

public class OutputView {

    public void printLottos(int lottoCount, Lottos lottos) {
        System.out.println(lottoCount + "개를 구매했습니다.");
        lottos.getLottos().forEach((key, value) -> System.out.println(value));
        System.out.println();
    }

    public void printLottoResultInfo() {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---------");
    }

    public void printLottoResult(List<LottoWinResult> lottoWinResults) {
        for (LottoWinResult lottoWinResult : lottoWinResults) {
            System.out.println(lottoWinResult.getMachCount() + "개 일치 (" + lottoWinResult.getPrizeAmount() + "원)- " + lottoWinResult.getWinCount() + "개");
        }
    }

}
