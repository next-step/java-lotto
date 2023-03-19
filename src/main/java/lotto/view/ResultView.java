package lotto.view;

import lotto.domain.enums.LottoRank;

import java.util.Map;

public class ResultView {

    public void printResult(Map<LottoRank, Integer> result, double totalRate){

        result.forEach((key, value)->{
            System.out.println( String.format(" %s - %s개", key, value) );
        });

        System.out.println ("총 수익률은 " + totalRate + "입니다."); //총 수익률은 x.xx입니다.

    }

}
