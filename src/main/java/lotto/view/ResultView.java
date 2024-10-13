package lotto.view;

import lotto.domain.Lottos;

public class ResultView {

    public void NumberOfLotto(int numberOfLotto){
        System.out.println(numberOfLotto+"개를 구매했습니다");
    }

    public void printPurchasedLottos(Lottos lottos){
        System.out.println(lottos.allPurchasedLottoNumber());
    }

}
