package Lotto;

import View.InputView;
import View.ResultView;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        LottoMachine lottoMachine = new LottoMachine(new RandomNumberGenerator());

        List<Lotto> lottos = lottoMachine.createLotto(new Money(InputView.insertBuyPrice()));

        ResultView.printLottoResult(lottos);
    }
}
