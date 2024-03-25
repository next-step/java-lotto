package lotto.view;

import lotto.domain.LottoNumbers;
import lotto.domain.Lotto;

public class ResultView {

    public static void printBuyLotto(Lotto lotto){
        System.out.println(lotto.lotto().size() + "개를 구매했습니다.");
        for(LottoNumbers lottoNumbers : lotto.lotto()){
            System.out.println(lottoNumbers.lottoNumbers());
        }
    }

}
