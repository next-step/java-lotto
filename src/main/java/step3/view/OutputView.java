package step3.view;

import step3.enumeration.LottoRank;
import step3.model.Lotto;
import step3.model.WinnerBoard;
import step3.utils.CalculateUtils;
import step3.utils.NumberUtils;

import java.util.List;

import static step3.enumeration.LottoRank.SECOND;

public class OutputView {

    public void viewLottoCount(int payPrice) {
        System.out.println(CalculateUtils.lottoCount(payPrice) + "개를 구매했습니다.");
    }

    public void viewLotto(List<Lotto> lottos) {
        lottos.forEach(lotto -> System.out.println(lotto.toString()));
    }

    public void viewLottoRating(WinnerBoard winnerBoard) {
        System.out.println("당첨 통계\n" + "---------");

        for (LottoRank rank : LottoRank.ALL_NORMAL_LOTTO_RANK) {
            System.out.println(rank.getMatch() + "개 일치 (" + LottoRank.getPriceByName(rank.name()) + "원) - " + NumberUtils.getSafeNumber(winnerBoard.winnerBoard.get(rank.name())) + "개");
        }

        viewLottoBonusScore(winnerBoard.winnerBoard.get(SECOND.name()));
    }

    public void viewLottoBonusScore(Integer count) {
        System.out.println(SECOND.getMatch() + "개 일치, 보너스 볼 일치 (" + SECOND.getPrice() + "원) - " + NumberUtils.getSafeNumber(count) + "개");
    }

    public void viewRating(Double rating) {
        System.out.println("총 수익률은 " + rating + "입니다.");
    }
}
