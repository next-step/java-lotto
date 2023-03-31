package lotto.view;

import lotto.domain.enums.LottoRank;

import java.util.*;

import static lotto.domain.enums.LottoRank.*;

public class ResultView {

    public void printTicket(ArrayList<Integer> lottoNumbers2)
    {
       System.out.println(lottoNumbers2.toString());
    }

    public void printResult(Map<LottoRank, Integer> result, double totalRate){

        String str ="";
        System.out.println("당첨 통계");
        System.out.println("---------");

        List<LottoRank> keyList = new ArrayList<>(result.keySet());
        Collections.sort(keyList, Collections.reverseOrder());
        for (LottoRank key : keyList) {
            if(key != MISS)
                System.out.println( String.format("%s - %s개", key, result.get(key)) );
        }

        if(totalRate < 1)
            str = "(기준이 1이기 때문에 결과적으로 손해라는 의미임)";
        System.out.println( String.format("총 수익률은 %.2f입니다.%s", totalRate, str));
    }


    public void printBuyTicket(int manual, int auto){
        System.out.println( String.format("수동으로 %d장, 자동으로 %d개를 구매했습니다.",  manual, auto) );
    }






}