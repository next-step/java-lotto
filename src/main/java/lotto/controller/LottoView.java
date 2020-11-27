package lotto.controller;

import lotto.model.Lotto;
import lotto.model.Rank;
import lotto.model.WinningCheckor;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.*;

public class LottoView {
    public static void main(String[] args){
        InputView inputView = new InputView();
        int money = inputView.buyLotto();

        Lotto lotto = new Lotto(money);
        inputView.printLottoNumbers(lotto.getLottoTickets());

        Set<Integer> preNumbers = inputView.inputPreWinningNumber();
        WinningCheckor winningCheckor = new WinningCheckor(preNumbers);
        EnumMap<Rank, Integer> winningStatics = winningCheckor.makeStatics(lotto.getLottoTickets());

        ResultView resultView = new ResultView();
        EnumMap<Rank, Integer> results = resultView.showWinningResult(winningStatics);
        double price = lotto.resultBenefit(results);
        resultView.printBenefits(price, money);

    }


}
