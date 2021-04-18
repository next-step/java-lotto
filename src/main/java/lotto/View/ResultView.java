package lotto.View;

import lotto.domain.Statistic;
import lotto.dto.InfoDto;

import java.util.List;
import java.util.Scanner;

public class ResultView {

    public static void printPurchaseNum(int purchaseNum){
        System.out.println(String.valueOf(purchaseNum)+" 개를 구매했습니다.");
    }

    public static void printLottoNumbers(String lottoNumbers){
        System.out.println(lottoNumbers);
    }

    public static void printStatistics(Statistic statistic){
        System.out.println("당첨통계");
        System.out.println("-----------------------");
        List<InfoDto> infoDtos = statistic.getInfoDtos();
        infoDtos.forEach(info->{
                    System.out.println(info.getCorrectNum()+"개 일치 ("+
                            info.getWinningPrice()+"원) - "+
                            info.getLottoNumWithCorrectNum()+"개");
                });
        System.out.println("총 수익률은 "+statistic.getRevenueRate()+"입니다.");

    }

}
