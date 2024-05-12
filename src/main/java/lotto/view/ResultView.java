package lotto.view;

import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.LottoNumbers;

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





    }

}
