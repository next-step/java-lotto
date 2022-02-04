package lotto.controller;

import lotto.domain.LottoBundle;
import lotto.domain.LottoCalculation;
import lotto.domain.LottoFullNumber;
import lotto.domain.LottoNumber;
import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.domain.Winning;
import lotto.view.UserConsole;
import lotto.view.UserResult;

public class Controller {

    public static void run() {
        Money money = UserConsole.inputString();

        LottoCalculation lottoCalculation = new LottoCalculation(money);
        int count = lottoCalculation.lottoCalculation();

        Lottos lottoBundle = LottoBundle.lottoBundle(count);
        UserResult.countMessage(lottoBundle);

        LottoFullNumber winningLottoNumber = UserConsole.winningLottoNumber();
        LottoNumber bonusLottoNumber = UserConsole.bonusLottoNumber();
        Winning winning = new Winning(winningLottoNumber, bonusLottoNumber);


    }
}
