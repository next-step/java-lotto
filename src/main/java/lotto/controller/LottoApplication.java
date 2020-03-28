package lotto.controller;

import lotto.service.LottoGame;
import lotto.domain.Money;
import lotto.domain.item.LottoTicket;
import lotto.view.InputView;
import lotto.view.ResultView;
import util.StringUtil;

import java.util.Collections;
import java.util.List;

public class LottoApplication {

    public static void main(String[] args) {
        String inputMoney = InputView.inputBuyAmount();
        Money money = new Money(StringUtil.parseStringToInt(inputMoney));

        LottoGame lottoGame = new LottoGame(money);
        lottoGame.buyAllLottoTicket();
        List<LottoTicket> lottos = lottoGame.getLottos();
        ResultView.printLoots(lottos);

        String luckyNumberInput = InputView.inputLuckyNumber();
        List<Integer> luckyNumber = StringUtil.splitStringToIntegers(luckyNumberInput);
        Collections.sort(luckyNumber);
        ResultView.printLuckyNumber(luckyNumber);


    }
}
