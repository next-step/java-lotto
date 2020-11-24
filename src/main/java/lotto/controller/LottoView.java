package lotto.controller;

import lotto.model.Lotto;
import lotto.model.WinningCheckor;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LottoView {
    public static void main(String[] args){
        InputView inputView = new InputView();
        int tickets = inputView.buyLotto(1000);

        Lotto lotto = new Lotto(tickets);
        inputView.printLottoNumbers(lotto.getLottoTickets());

        List<Integer> preNumbers = inputView.inputPreWinningNumber();
        WinningCheckor winningCheckor = new WinningCheckor(preNumbers);
        Map<Integer,Integer> winningStatics = winningCheckor.makeStatics(lotto.getLottoTickets());
        //Map<Integer,Integer> winningStatics =  lotto.makeStatics(preNumbers);

        ResultView resultView = new ResultView(tickets);
        resultView.showWinningResult(winningStatics);

    }


}
