package lotto.view;

import java.util.Arrays;
import java.util.Map;

import lotto.domain.LottoTickets;
import lotto.domain.Lotto;
import lotto.domain.Prize;


public class OutputView {

    //당첨 통계
    //---------
    //3개 일치 (5000원)- 1개
    //4개 일치 (50000원)- 0개
    //5개 일치 (1500000원)- 0개
    //5개 일치, 보너스 볼 일치(30000000원) - 0개
    //6개 일치 (2000000000원)- 0개
    //총 수익률은 0.35입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)

    private static final String WINNING_RESULT_TEXT = "\n당첨 통계\n---------";
    private static final String MATCHED_NUMBER_TEXT = "%d개 일치";
    private static final String CASH_AND_PRIZE_TEXT = " (%d원) - %d개\n";
    private static final String ROI_TEXT = "총 수익률은 %0.2f 입니다.\n";
    private static final String NUMBER_OF_EACH_TICKETS = "\n수동으로 %d장, 자동으로 %d개를 구매했습니다.";
    private static final String FIVE_WITH_BONUS_CASE_TEXT = ", 보너스 볼 일치";

    public static void printAllLotto(LottoTickets lottoTickets) {
        System.out.println();
        for (Lotto lotto : lottoTickets.getLottoTickets()) {
            System.out.println(lotto.getAsIntegerList());
        }
        System.out.println();
    }

    public static void printWinningResult(Map<Prize, Integer> prizeBoard) {
        System.out.println(WINNING_RESULT_TEXT);
        Arrays.stream(Prize.values()).forEach(value -> {
            if (value.getMatchedNumber() >= Prize.THREE.getMatchedNumber()) {
                System.out.printf(MATCHED_NUMBER_TEXT, value.getMatchedNumber());
                printFiveWithBonusBallCase(value);
                System.out.printf(CASH_AND_PRIZE_TEXT, value.getCash(), prizeBoard.get(value));
            }

        });
    }

    public static void printReturnOnInvestment(double returnOnInvestment) {
        System.out.printf(ROI_TEXT, returnOnInvestment);
    }

    private static void printFiveWithBonusBallCase(Prize prize) {
        if (prize.equals(Prize.FIVE_WITH_BONUS)) {
            System.out.print(FIVE_WITH_BONUS_CASE_TEXT);
        }
    }

    public static void printNumberOfEachTicket(int numberOfTicket, int numberOfManualLotto) {
        int numberOfAutoLotto = numberOfTicket - numberOfManualLotto;
        System.out.printf(NUMBER_OF_EACH_TICKETS, numberOfManualLotto, numberOfAutoLotto);
    }
}
