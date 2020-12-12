package lotto.controller;

import lotto.model.*;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.*;

public class LottoController {
    public static void main(String[] args){
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();

        int money = inputView.buyLotto();
        int manualCount = inputView.inputManualCount();
        String[] manualNumbers = inputView.inputManualLottoNumber(manualCount);

        Lotto lotto = new Lotto(money,manualNumbers);
        Long autoCount = lotto.getLottoTickets().getAutoTicketCount();
        resultView.printNumberOfLottos(autoCount, manualCount);
        inputView.printLottoNumbers(lotto.getLottoTickets());

        Set<Integer> preNumbers = inputView.inputPreWinningNumber();
        int bonusNumber = inputView.inputBonus();
        WinningCheckor winningCheckor = new WinningCheckor(preNumbers, bonusNumber);
        EnumMap<Rank, Integer> winningStatics = winningCheckor.makeStatics(lotto.getLottoTickets());


        EnumMap<Rank, Integer> results = resultView.showWinningResult(winningStatics);
        double price = lotto.resultBenefit(results);
        resultView.printBenefits(price, money);

    }


}
