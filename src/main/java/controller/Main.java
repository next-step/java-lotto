package controller;

import domain.LottoMachine;
import view.InputView;
import view.ResultView;

public class Main {

  public static void main(String[] args) {
    InputView inputView = new InputView();
    ResultView resultView = new ResultView();
    LottoMachine lottoMachine = new LottoMachine();

    resultView.print("구입금액을 입력해 주세요.");
    int userMoney = inputView.inputInteger();

    int count = lottoMachine.createLotto(userMoney);
    resultView.print(String.format("%d개를 구매했습니다.", count));
    lottoMachine.getAllLottoList().forEach(resultView::print);

    resultView.print("지난 주 당첨 번호를 입력해 주세요.");
    resultView.printLottoResult(lottoMachine.getLottoResult(inputView.inputIntegerList()));
  }
}
