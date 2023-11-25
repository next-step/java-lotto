package step4.view;

import step4.enumeration.LottoRank;
import step4.model.Lotto;

import java.util.List;
import java.util.Map;

public class OutputView {

    public void viewLottoCount(int allLottoCount, int manualLottoCount) {
        System.out.println("수동으로 " + manualLottoCount + ", 자동으로 " + allLottoCount + "개를 구매했습니다.");
    }

    public void viewLotto(List<Lotto> lottos) {
        lottos.forEach(lotto -> System.out.println(lotto.toString()));
    }

    public void viewLottoRating(Map<LottoRank, Integer> winnerBoard) {
        System.out.println("당첨 통계\n" + "---------");

        for (Map.Entry<LottoRank, Integer> board : winnerBoard.entrySet()) {
            System.out.printf((board.getKey().getMessage()) + "%n", board.getValue());
        }
    }

    public void viewRating(Double rating) {
        System.out.println("총 수익률은 " + rating + "입니다.");
    }
}
