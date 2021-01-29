package lotto.view;

import lotto.domain.LottoTicket;
import lotto.domain.Rank;

import java.util.Map;

public class OutputView {

    public static void printNumberOfLotto(int numberOfLotto) {
        System.out.println(numberOfLotto + "개를 구매했습니다.");
    }

    public static void printLottoPickedNumber(LottoTicket lottoTicket) {
        System.out.println(lottoTicket.getPickedNumbers());
    }

    public static void printLottoServiceResult(Map<Rank, Integer> lottoRankingStatus, double interestRate) {
        System.out.println("당첨 통계");
        System.out.println("--------");
        System.out.printf("3개 일치 (%d원) - %d\n", Rank.FIFTH.getReward(), lottoRankingStatus.get(Rank.FIFTH));
        System.out.printf("4개 일치 (%d원) - %d\n", Rank.FOURTH.getReward(), lottoRankingStatus.get(Rank.FOURTH));
        System.out.printf("5개 일치 (%d원) - %d\n", Rank.THIRD.getReward(), lottoRankingStatus.get(Rank.THIRD));
        System.out.printf("5개 일치, 보너스 볼 일치 (%d원) - %d\n", Rank.SECOND.getReward(), lottoRankingStatus.get(Rank.SECOND));
        System.out.printf("6개 일치 (%d원) - %d\n", Rank.FIRST.getReward(), lottoRankingStatus.get(Rank.FIRST));
        System.out.printf("총 수익률은 %f 입니다.\n", interestRate);
    }
}
