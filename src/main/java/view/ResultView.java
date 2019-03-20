package view;

import domain.LottoGame;
import domain.LottoResult;

import java.util.List;

public class ResultView {

    public static void printProfitStatics(List<LottoResult> result){
        System.out.println("당첨 통계\n-----------");
        for(LottoResult lottoResult : result) {
            if(lottoResult.getNumberOfMatch() >- 3) {
            System.out.println(lottoResult.getNumberOfMatch() + "개 일치 (" + lottoResult.getProfitMoney()
                                + ")원 - " + lottoResult.getCount() + "개");
        }
        }
    }

    public static void printProfitRate(List<LottoResult> results, int inputMoney){
        System.out.println("총 수익률은 " + calculateProfitRate(results, inputMoney) + "입니다.");
    }

    private static float calculateProfitRate(List<LottoResult> results, int inputMoney){
        int totalProfitMoney = 0;
        for(LottoResult result : results){
            totalProfitMoney += result.getProfitMoney();
        }
        return (float) (totalProfitMoney / inputMoney);
    }
}
