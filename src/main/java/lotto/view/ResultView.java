package lotto.view;

import lotto.domain.LottoGame;
import lotto.domain.enums.LottoRank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import static lotto.domain.enums.LottoRank.MISS;

public class ResultView {

    public void printLotto(InputView inputView, LottoGame lottoGame)
    {
        StringBuilder sb = new StringBuilder();
        sb.append("\n수동으로 "+ inputView.getManualCount()+"장,");
        sb.append("자동으로 "+ inputView.getAutoCount()+"장을 구매했습니다.");
        System.out.println(sb);
        lottoGame.getLottoNumbers().stream().forEach(System.out::println);
        System.out.println();
    }

    public void printResult(Map<LottoRank, Integer> result, double totalRate){

        String str ="";
        StringBuilder sb = new StringBuilder();
        sb.append("\n당첨 통계\n---------");
        System.out.println(sb);

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

}