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
        System.out.println(lotto.getLottoTickets().getTicketCount()+"개를 구매했습니다.");
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
