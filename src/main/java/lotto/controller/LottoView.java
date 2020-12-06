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
        int manualCount = inputView.inputManualCount();
        String[] manualNumbers = inputView.inputManualLottoNumber(manualCount);

        Lotto lotto = new Lotto(money,manualNumbers);
        System.out.println("수동으로"+manualCount+"장, 자동으로 "+(lotto.getLottoTickets().getTicketCount()-manualCount)+"개를 구매했습니다.");
        inputView.printLottoNumbers(lotto.getLottoTickets());

        Set<Integer> preNumbers = inputView.inputPreWinningNumber();
        int bonusNumber = inputView.inputBonus();
        WinningCheckor winningCheckor = new WinningCheckor(preNumbers, bonusNumber);
        EnumMap<Rank, Integer> winningStatics = winningCheckor.makeStatics(lotto.getLottoTickets());

        ResultView resultView = new ResultView();
        EnumMap<Rank, Integer> results = resultView.showWinningResult(winningStatics);
        double price = lotto.resultBenefit(results);
        resultView.printBenefits(price, money);

    }


}
