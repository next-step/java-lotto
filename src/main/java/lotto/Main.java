package lotto;

import lotto.view.InputView;
import lotto.view.ResultView;

public class Main {

    public static void main(String[] args){

        Lottos lottos = new Lottos(InputView.askPurchaseAmount());

        ResultView.printPurchasedLottoCount(lottos.getLottoCount());
        ResultView.printLottosNumber(lottos);

    }
}
