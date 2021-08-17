package Lotto;

import View.InputView;
import View.ResultView;

import java.util.List;

//import View.ResultView;

public class Main {

    public static void main(String[] args) {

        LottoMachine lottoMachine = new LottoMachine(new RandomNumberGenerator());

        List<Lotto> lottos = lottoMachine.createLotto(new Money(InputView.insertBuyPrice()));

        List<Lotto> passvieLottos = lottoMachine.createPassiveLotto(InputView.insertPassiveCount());

        ResultView.printLottoResult(lottos, passvieLottos);
    }
}
