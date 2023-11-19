package step3.view;

import step3.enumeration.LottoRank;
import step3.model.Lotto;
import step3.utils.CalculateUtils;
import step3.utils.NumberUtils;

import java.util.List;
import java.util.Map;

import static step2.enumeration.LottoRank.ZERO;

public class OutputView {

    public void viewLottoCount(int payPrice) {
        System.out.println(CalculateUtils.lottoCount(payPrice) + "개를 구매했습니다.");
    }

    public void viewLotto(List<Lotto> lottos) {
        System.out.println(lottos.toString() + "\n");
    }

    public void viewLottoRating(Map<Integer, Long> winnerScore, Map<Integer, Long> bonusScore) {
        System.out.println("당첨 통계\n" + "---------");
        viewLottoRatingWithoutScore(winnerScore);
        viewLottoBonusScore(bonusScore);
        LottoRank.getMatches()
            .stream()
            .filter(match -> winnerScore.get(match) != null)
            .forEach(match -> System.out.println(match + "개 일치 (" + LottoRank.getPriceByMatch(match) + "원) - " + winnerScore.get(match) + "개"));
    }

    public void viewLottoRatingWithoutScore(Map<Integer, Long> winnerScore) {
        LottoRank.getMatches()
                .stream()
                .filter(match -> winnerScore.get(match) == null)
                .forEach(match -> System.out.println(match + "개 일치 (" + LottoRank.getPriceByMatch(match) + "원) - " + ZERO.getPrice() + "개"));
    }

    public void viewLottoBonusScore(Map<Integer, Long> bonusScore) {
        LottoRank.getBonusMatches()
                .forEach(match -> System.out.println(match + "개 일치, 보너스 볼 일치 (" + LottoRank.getBonusPriceByMatch(match) + "원) - " + NumberUtils.getSafeNumber(bonusScore.get(match)) + "개"));
    }

    public void viewRating(Double rating) {
        System.out.println("총 수익률은 " + rating + "입니다.");
    }
}
