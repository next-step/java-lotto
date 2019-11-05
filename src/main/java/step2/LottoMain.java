package step2;

import java.util.ArrayList;

public class LottoMain {

  public static void main(String[] args) {
    InputView inputView = new InputView();
    LottoMachine lottoMachine = new LottoMachine(inputView.inputAmount());
    ArrayList<ArrayList<String>> lottoNumberTicketArr = lottoMachine.start();
    ReviewLotto reviewLotto = new ReviewLotto(inputView.inputLottoWinnerNumber(),
        lottoNumberTicketArr);
    ResultView resultView = new ResultView(lottoMachine, reviewLotto);
    resultView.statistics();
    resultView.printEarnSummary();
  }
}
