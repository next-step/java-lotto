package lotto.view;

import lotto.domain.enums.LottoRank;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ResultView {

    public void printResult(Map<LottoRank, Integer> result, double totalRate){

        List<LottoRank> keyList = new ArrayList<>(result.keySet());
        keyList.sort((s1, s2) -> s1.compareTo(s2));
        for (LottoRank key : keyList) {
            System.out.println( String.format("%s - %s개", key, result.get(key)) );
        }

        System.out.println ("총 수익률은 " + totalRate + "입니다."); //총 수익률은 x.xx입니다.

    }

}
