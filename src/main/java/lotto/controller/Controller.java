package lotto.controller;

import lotto.domain.LottoBundle;
import lotto.domain.LottoCalculation;
import lotto.domain.Lottos;
import lotto.view.UserConsole;
import lotto.view.UserResult;

public class Controller {

    public static void run(){
        int money = UserConsole.inputString();

        LottoCalculation lottoCalculation = new LottoCalculation(money);
        int count = lottoCalculation.lottoCalculation();

        Lottos lottoBundle = LottoBundle.lottoBundle(count);
        UserResult.countMessage(lottoBundle);

    }
}
