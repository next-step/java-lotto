package lotto.view;

import lotto.domain.LottoMatchNumber;
import lotto.domain.LottoTicket;

import java.util.HashMap;
import java.util.List;

public class ResultView {

    public static void printLottoTickets(List<LottoTicket> lottoTickets) {
        System.out.println(lottoTickets.size() + "개를 구매했습니다.");

        for (LottoTicket lottoTicket : lottoTickets) {
            System.out.println(lottoTicket.toString());
        }
    }

    public static void printWinLottoResult(HashMap<LottoMatchNumber, Integer> results) {
        System.out.println("당첨 통계");
        System.out.println("---------");

        for (LottoMatchNumber matchType: LottoMatchNumber.values()) {
            System.out.println(matchType.toString() + "- " + results.get(matchType) + "개");
        }
    }

    public static void printIncomeResult(double income){
        System.out.printf("총 수익률은 %.2f 입니다.", income);
        System.out.println();
    }
}
