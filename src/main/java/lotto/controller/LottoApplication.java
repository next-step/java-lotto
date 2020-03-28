package lotto.controller;

import lotto.domain.Money;
import lotto.service.LottoGame;
import lotto.view.InputView;
import lotto.view.LottoDto;
import lotto.view.ResultView;
import lotto.view.StatisticDataDto;
import util.StringUtil;

import java.util.Collections;
import java.util.List;

public class LottoApplication {

    public static void main(String[] args) {
        String inputMoney = InputView.inputBuyAmount();
        Money money = new Money(StringUtil.parseStringToInt(inputMoney));

        LottoGame lottoGame = new LottoGame(money);
        LottoDto dto = lottoGame.play();
        ResultView.printLoots(dto);

        String luckyNumberInput = InputView.inputLuckyNumber();
        List<Integer> luckyNumber = StringUtil.splitStringToIntegers(luckyNumberInput);
        Collections.sort(luckyNumber);
        ResultView.printLuckyNumber(luckyNumber);

        LottoDto winGame = lottoGame.findWinGame(luckyNumber);
        ResultView.printResult(winGame);
    }
}
