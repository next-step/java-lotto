package view;

import domain.LottoNumber;
import domain.LottoResult;
import domain.LottoWinnigCalculator;

import java.util.ArrayList;
import java.util.Map;

public class ResultView {
    public static void printLottoNumber(ArrayList<LottoNumber> lotto) {
        System.out.println(lotto.size() + "개를 구매하셨습니다.");
        for (int i = 0; i < lotto.size(); i++) {
            System.out.println(lotto.get(i).getElement());
        }
        System.out.println("\n");
    }

    public static void printResult() {
        System.out.println("\n");
        System.out.println("당첨 통계");
        System.out.println("---------");
//        System.out.println(LottoResult.FORTH_WINNING_POINT + "개 일치 (" + LottoResult.FORTH_WINNING_PRIZE + "원)- " + makeListOfWinner.get(LottoResult.FORTH_WINNING_PRIZE) + "개");
//        System.out.println(LottoResult.THIRD_WINNING_POINT + "개 일치 (" + LottoResult.THIRD_WINNING_PRIZE + "원)- " + makeListOfWinner.get(LottoResult.THIRD_WINNING_PRIZE) + "개");
//        System.out.println(LottoResult.SECOND_WINNING_POINT + "개 일치 (" + LottoResult.SECOND_WINNING_PRIZE + "원)- " + makeListOfWinner.get(LottoResult.SECOND_WINNING_PRIZE) + "개");
//        System.out.println(LottoResult.FIRST_WINNING_POINT + "개 일치 (" + LottoResult.FIRST_WINNING_PRIZE + "원)- " + makeListOfWinner.get(LottoResult.FIRST_WINNING_PRIZE) + "개");
        System.out.print("총 수익률은  " + LottoWinnigCalculator.getPercentOfRevenue() + "입니다. 기준이 1이기 때문에 결과적으로 " + LottoWinnigCalculator.judgeResult() + "라는 의미임)");
    }
}
