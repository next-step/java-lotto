package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Lottos;

public class UserResult {
    private final static String LOTTO_COUNT_MESSAGE = "개를 구매했습니다.";

    private UserResult(){

    }

    public static void countMessage(Lottos lottos){
        System.out.println(lottos.getLottosSize()+LOTTO_COUNT_MESSAGE);
        for(Lotto lotto : lottos.lottos()){
            System.out.println(lotto.getLottoNumber());
        }

    }
}
