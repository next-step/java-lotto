package step4.view;

import java.util.List;
import java.util.Map;
import step4.domain.LottoNumbers;
import step4.domain.Prize;
import step4.domain.Ticket;
import step4.dto.TicketDTO;

public class OutputView {

    public static void printPriceNotification() {
        System.out.println("구매금액을 입력해 주세요");
    }


    public static void printManualLottoCount() {
        System.out.println();
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
    }

    public static void printManualLottoNumberNotification() {
        System.out.println();
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
    }

    public static void printPurchaseResult(final TicketDTO ticketDTO) {
        System.out.println();
        System.out.println("수동으로 " + ticketDTO.getCountOfManualTicket() + "장," +
            "자동으로 " + ticketDTO.getCountOfAutoTicket() + "개를 구매했습니다.");
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
        drawLottoResult.remove(Prize.MISS);
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

    public static void printGrossReturn(final double purchasePrice, final int totalIncome) {
        final double grossReturn = totalIncome / purchasePrice;
        System.out.println("총 수익률은 " + String.format("%.2f", grossReturn) + "입니다.");
    }

    public static void printBonusBallNotification() {
        System.out.println("보너스 볼을 입력해 주세요.");
    }
}
