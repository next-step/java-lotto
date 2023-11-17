package step2.view;

import step2.enumeration.LottoRank;
import step2.model.Lotto;

import java.util.List;
import java.util.Map;

import static step2.enumeration.LottoRank.ZERO;
import static step2.model.Lotto.EACH_LOTTO_PRICE;

public class OutputView {

    public void viewLottoCount(int payPrice) {
        System.out.println(payPrice / EACH_LOTTO_PRICE + "개를 구매했습니다.");
    }

    public void viewLotto(List<Lotto> lottos) {
        System.out.println(lottos.toString() + "\n");
    }

    public void viewLottoRating(Map<Integer, Long> winnerScore) {
        System.out.println("당첨 통계\n" + "---------");
        for (int match : LottoRank.getMatches()) {
            if (winnerScore.get(match) != null) {
                System.out.println(match + "개 일치 (" + LottoRank.getPriceByMatch(match) + "원) - " + winnerScore.get(match) + "개");
            }

            System.out.println(match + "개 일치 (" + LottoRank.getPriceByMatch(match) + "원) - " + ZERO.getPrice() + "개");
        }
    }

    public void viewRating(Double rating) {
        System.out.println("총 수익률은 " + rating + "입니다.");
    }
}
