package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoNumbers;
import lotto.enums.PrizeMoney;

import java.util.Map;

public class ResultView {

    public static void printBuyLotto(Lotto lotto){
        System.out.println(lotto.lotto().size() + "개를 구매했습니다.");
        for(LottoNumbers lottoNumbers : lotto.lotto()){
            System.out.println(lottoNumbers.lottoNumbers());
        }
    }

    public static void printWinningResult(Map<String, Object> winningResult){
        System.out.println("  당첨 통계 ");
        System.out.println("------------");

        Map<Integer, Integer> winningCounts = (Map<Integer, Integer>) winningResult.get("winningCounts");
        double rateOfReturn = (double) winningResult.get("rateOfReturn");

        for (int i = 3; i <= 6; i++) {
            int count = winningCounts.getOrDefault(i, 0);
            System.out.println(i + "개 일치 (" + PrizeMoney.valueOf(i).prizeMoney() + "원) - " + count + "개");
        }

        System.out.println("총 수익률은 " + rateOfReturn + "입니다.");
    }

}
