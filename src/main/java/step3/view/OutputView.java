package step3.view;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import step3.domain.LottoNumber;
import step3.domain.LottoNumbers;
import step3.domain.Prize;
import step3.domain.Ticket;

public class OutputView {

    public static void printPriceNotification() {
        System.out.println("구매금액을 입력해 주세요");
    }

    public static void printPurchaseResult(final Ticket ticket) {
        System.out.println(ticket.getTicketCount() + "개를 구매했습니다.");
    }

    public static void printLottoNumbers(final List<LottoNumbers> lottoNumbers) {
        for (LottoNumbers lottoNumber : lottoNumbers) {
            lottoNumber.getLottoNumbers()
                .stream()
                .forEach(number -> System.out.print(number.getLottoNumber() + " "));
            System.out.println();
        }
        System.out.println();
    }

    public static void printWinningNumberNotification() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
    }

    public static void printDrawResult(final Map<Prize, Integer> drawLottoResult) {
        System.out.println();
        for (Prize prize : drawLottoResult.keySet()) {
            printEachResult(drawLottoResult, prize);
        }
    }

    private static void printEachResult(Map<Prize, Integer> drawLottoResult, Prize prize) {
        int matchCount = prize.getCountOfMatch();
        int reward = prize.getReward();

        if (prize.equals(Prize.SECOND)) {
            System.out.println(matchCount + "개 일치, 보너스 볼 일치(30000000원) -" + drawLottoResult.get(prize));
            return;
        }

        System.out.println(matchCount + "개 일치 (" + reward + ")- " + drawLottoResult.get(prize));
    }

    public static void printGrossReturn(final Ticket ticket, final int totalIncome) {
        final double purchasePrice = ticket.getPurchasePrice();
        final double grossReturn = totalIncome / purchasePrice;
        System.out.println("총 수익률은 " + String.format("%.2f", grossReturn) + "입니다.");
    }

    public static void printBonusBallNotification() {
        System.out.println("보너스 볼을 입력해 주세요.");
    }
}
