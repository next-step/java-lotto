package lotto.View;

import lotto.domain.Statistic;

import java.util.Map;

public class ResultView {

    public static void printPurchaseNum(int purchaseNum){
        System.out.println(String.valueOf(purchaseNum)+" 개를 구매했습니다.");
    }

    public static void printLottoNumbers(String lottoNumbers){
        System.out.println(lottoNumbers);
    }

    public static void printStatistics(int purchasedAmount,Map<Long,Integer> countLottoPerCorrectNumber){
        System.out.println("당첨통계");
        System.out.println("-----------------------");

        countLottoPerCorrectNumber.entrySet().stream()
                .forEach( entry ->
                        System.out.println(entry.getKey()+"개 일치 ("+
                                Statistic.WINNINGPRICE[Math.toIntExact(entry.getKey())]+"원)- "+
                        entry.getValue()+"개"));

        System.out.println("총 수익률은 "+Statistic.getRevenueRate(purchasedAmount,countLottoPerCorrectNumber)+"입니다.");

    }

}
