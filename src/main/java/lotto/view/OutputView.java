package lotto.view;

import java.util.Arrays;
import java.util.Map;

import lotto.domain.LottoTickets;
import lotto.domain.PlayersLotto;
import lotto.domain.Prize;
import lotto.util.InfoStrings;


public class OutputView {

    public static void printNumberOfLottoInfo(int numberOfManualLotto, int numberOfAutoLotto) {
        String.format(InfoStrings.INFO_OUTPUT_PURCHASE, numberOfManualLotto, numberOfAutoLotto);
    }

    public static void printAllLotto(LottoTickets lottoTickets) {
        System.out.println();
        for (PlayersLotto lotto : lottoTickets.getLottoTickets()) {
            System.out.println(lotto.getAsIntegerList());
        }
        System.out.println();
    }

    public static void printWinningResult(Map<Prize, Integer> prizeBoard) {
        System.out.println(InfoStrings.INFO_LOTTO_RESULT_STATISTIC);
        Arrays.stream(Prize.values()).forEach(prize -> {
            if (prize.getMatchedNumber() < Prize.THREE.getMatchedNumber()) {
                return;
            }
            printPrizeCount(prize);
            checkFiveWithBonusBallCase(prize);
            printValueAndCount(prize,prizeBoard);
        });
    }

    public static void printReturnOnInvestment(double returnOnInvestment) {
        String.format(InfoStrings.INFO_OUTPUT_LOTTO_RETURN_OF_INVESTMENT, returnOnInvestment);
    }

    private static void printPrizeCount(Prize prize) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(prize.getMatchedNumber());
        stringBuffer.append("개 일치");
        System.out.print(stringBuffer.toString());
    }

    private static void printValueAndCount(Prize prize, Map<Prize, Integer> prizeBoard) {
        StringBuilder sb = new StringBuilder();
        sb.append(" (");
        sb.append(prize.getCash());
        sb.append("원) - ");
        sb.append(prizeBoard.get(prize));
        sb.append("개");
        System.out.println(sb.toString());
    }

    private static void checkFiveWithBonusBallCase(Prize prize) {
        if (prize.equals(Prize.FIVE_WITH_BONUS)) {
            System.out.print(", 보너스 볼 일치");
        }
    }
}