package view;

import domain.LottoNumber;
import domain.LottoResult;
import domain.LottoData;

import java.util.ArrayList;

public class ResultView {
    public static void printLottoNumber(ArrayList<LottoNumber> lotto) {
        System.out.println(lotto.size() + "개를 구매하셨습니다.");
        for (LottoNumber lottoNumber : lotto) {
            System.out.println(lottoNumber.getElement());
        }
        System.out.println("\n");
    }

    public static void printResult(LottoResult gameResult) {
        System.out.println("\n");
        System.out.println("당첨 통계");
        System.out.println("---------");
        System.out.println(LottoData.FORTH_WINNER.getMatch() + "개 일치 (" + LottoData.FORTH_WINNER.getPrize() + "원)- " + gameResult.getWinnerGroup().get(LottoData.FORTH_WINNER.getPrize()) + "개");
        System.out.println(LottoData.THIRD_WINNER.getMatch() + "개 일치 (" + LottoData.THIRD_WINNER.getPrize() + "원)- " + gameResult.getWinnerGroup().get(LottoData.THIRD_WINNER.getPrize()) + "개");
        System.out.println(LottoData.SECOND_WINNER.getMatch() + "개 일치 (" + LottoData.SECOND_WINNER.getPrize() + "원)- " + gameResult.getWinnerGroup().get(LottoData.SECOND_WINNER.getPrize()) + "개");
        System.out.println(LottoData.BONUS_SECOND_WINNER.getMatch() + "개 일치 보너스 볼 일치(" + LottoData.BONUS_SECOND_WINNER.getPrize() + "원)- " + gameResult.getWinnerGroup().get(LottoData.BONUS_SECOND_WINNER.getPrize()) + "개");
        System.out.println(LottoData.FIRST_WINNER.getMatch() + "개 일치 (" + LottoData.FIRST_WINNER.getPrize() + "원)- " + gameResult.getWinnerGroup().get(LottoData.FIRST_WINNER.getPrize()) + "개");
        System.out.print("총 수익률은  " + gameResult.getPercentOfRevenue() + "입니다. 기준이 1이기 때문에 결과적으로 " + gameResult.judgeResult() + "라는 의미임)");
    }
}
