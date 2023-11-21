package step4.view;

import step4.enumeration.LottoRank;
import step4.model.Lotto;
import step4.utils.CalculateUtils;

import java.util.List;
import java.util.Map;

import static step4.enumeration.LottoRank.*;

public class OutputView {

    public void viewLottoCount(int payPrice, int manualLottoCount) {
        System.out.println("수동으로 " + manualLottoCount + ", 자동으로 " + CalculateUtils.autoLottoCount(CalculateUtils.lottoCount(payPrice), manualLottoCount) + "개를 구매했습니다.");
    }

    public void viewLotto(List<Lotto> lottos) {
        lottos.forEach(lotto -> System.out.println(lotto.toString()));
    }

    public void viewLottoRating(Map<LottoRank, Integer> winnerBoard) {
        System.out.println("당첨 통계\n" + "---------");

        System.out.println(FIRST.getMatch() + "개 일치 (" + LottoRank.getPriceByName(FIRST) + "원) - " + winnerBoard.get(FIRST) + "개");
        System.out.println(SECOND.getMatch() + "개 일치, 보너스 볼 일치 (" + SECOND.getPrice() + "원) - " + winnerBoard.get(SECOND) + "개");
        System.out.println(THIRD.getMatch() + "개 일치 (" + LottoRank.getPriceByName(THIRD) + "원) - " + winnerBoard.get(THIRD) + "개");
        System.out.println(FOURTH.getMatch() + "개 일치 (" + LottoRank.getPriceByName(FIRST) + "원) - " + winnerBoard.get(FOURTH) + "개");
        System.out.println(FIFTH.getMatch() + "개 일치 (" + LottoRank.getPriceByName(FIRST) + "원) - " + winnerBoard.get(FIFTH) + "개");
    }

    public void viewRating(Double rating) {
        System.out.println("총 수익률은 " + rating + "입니다.");
    }
}
