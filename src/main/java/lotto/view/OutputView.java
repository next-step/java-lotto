package lotto.view;

import lotto.domain.LottoTicket;
import lotto.domain.Rank;

import java.util.Arrays;
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
        Arrays.stream(Rank.values())
                .filter(rank -> !rank.equals(Rank.NOTHING))
                .forEach(rank -> System.out.printf("%s 일치 (%d원) - %d\n",
                        rank.getCountMessage(),
                        rank.getReward(),
                        lottoRankingStatus.get(rank)));
        System.out.printf("총 수익률은 %.1f 입니다.\n", interestRate);
    }
}
