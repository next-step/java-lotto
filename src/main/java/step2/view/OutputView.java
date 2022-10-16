package step2.view;

import java.util.List;
import java.util.Map;
import step2.domain.LottoNumbers;
import step2.domain.Prize;
import step2.domain.Ticket;

public class OutputView {

    public static void printPriceNotification() {
        System.out.println("구매금액을 입력해 주세요");
    }

    public static void printPurchaseResult(final Ticket ticket) {
        System.out.println(ticket.getTicketCount() + "개를 구매했습니다.");
    }

    public static void printLottoNumbers(final List<LottoNumbers> lottoNumbers) {
        for (LottoNumbers lottoNumber : lottoNumbers) {
            System.out.println(lottoNumber.getLottoNumbers());
        }
        System.out.println();
    }

    public static void printWinningNumberNotification() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
    }

    public static void printDrawResult(final Map<Integer, Integer> drawLottoResult) {
        System.out.println();
        for (int matchCount : drawLottoResult.keySet()) {
            int prizeMoney = Prize.getPrizeMoney(matchCount);
            System.out.println(matchCount + "개 일치 (" + prizeMoney + ")-" + drawLottoResult.get(matchCount) );
        }
    }

    public static void printGrossReturn(final Ticket ticket, final int totalIncome) {
        final double purchasePrice = ticket.getPurchasePrice();
        final double grossReturn = totalIncome / purchasePrice;
        System.out.println("총 수익률은 " + String.format("%.2f", grossReturn) + "입니다.");
    }
}
