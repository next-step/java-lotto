package lotto.view;

import lotto.domain.LottoTicket;
import lotto.domain.Rank;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class OutputView {

    public static void printNumberOfLotto(int countOfLottoManual, int countOfLottoAuto, List<LottoTicket> lottoTicket) {
        System.out.printf("수동으로 %d장, 자동으로 %d개를 구매했습니다.\n", countOfLottoManual, countOfLottoAuto);
        lottoTicket.forEach(OutputView::printLottoPickedNumber);
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
