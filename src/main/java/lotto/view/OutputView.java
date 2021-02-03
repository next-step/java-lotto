package lotto.view;

import java.util.Arrays;
import java.util.Map;

import lotto.domain.LottoTickets;
import lotto.domain.PlayersLotto;
import lotto.domain.Prize;


public class OutputView {

    public static void printNumberOfLottoInfo(int numberOfLotto) {
        System.out.println(numberOfLotto + "개를 구매하셨습니다.");
    }

    public static void printAllLotto(LottoTickets lottoTickets) {
        System.out.println();
        for (PlayersLotto lotto : lottoTickets.getLottoTickets()) {
            System.out.println(lotto.getAsIntegerList());
        }
        System.out.println();
    }

    public static void printWinningResult(Map<Prize, Integer> prizeBoard) {
        System.out.println("\n당첨 통계");
        System.out.println("---------");
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
        System.out.println("총 수익률은 " + returnOnInvestment + "입니다.");
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