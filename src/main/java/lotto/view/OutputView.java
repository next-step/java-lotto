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
            if (prize.getMatchedNumber() >= Prize.THREE.getMatchedNumber()) {
                printPrizeCount(prize);
                checkFiveWithBonusBallCase(prize);
                printValueAndCount(prize,prizeBoard);
            }
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
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(" (");
        stringBuffer.append(prize.getCash());
        stringBuffer.append("원) - ");
        stringBuffer.append(prizeBoard.get(prize));
        stringBuffer.append("개");
        System.out.println(stringBuffer.toString());
    }

    private static void checkFiveWithBonusBallCase(Prize prize) {
        if (prize.equals(Prize.FIVE_WITH_BONUS)) {
            System.out.print(", 보너스 볼 일치");
        }
    }

}

//당첨 통계
//---------
//3개 일치 (5000원)- 1개
//4개 일치 (50000원)- 0개
//5개 일치 (1500000원)- 0개
//5개 일치, 보너스 볼 일치(30000000원) - 0개
//6개 일치 (2000000000원)- 0개
//총 수익률은 0.35입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)