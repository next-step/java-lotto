package controller;

import domain.lotto.vo.LottoNumber;
import domain.machine.LottoMachine;
import domain.lotto.vo.WinNumbers;
import view.InputView;
import view.ResultView;
import java.util.List;

public class Main {

  public static void main(String[] args) {
    InputView inputView = new InputView();
    ResultView resultView = new ResultView();
    LottoMachine lottoMachine = new LottoMachine();

    resultView.print("구입금액을 입력해 주세요.");
    int userMoney = inputView.inputInteger();

    resultView.print("수동으로 구매할 로또 수를 입력해 주세요.");
    int manualLottoCount = inputView.inputInteger();

    resultView.print("수동으로 구매할 번호를 입력해 주세요.");
    List<List<LottoNumber>> manualLottoNumberList = inputView.inputManualLottoNumberList(manualLottoCount);

    int count = lottoMachine.createLotto(userMoney, manualLottoNumberList);
    resultView.print(String.format("%d개를 구매했습니다.", count));
    lottoMachine.getAllLottoList().forEach(resultView::print);

    resultView.print("지난 주 당첨 번호를 입력해 주세요.");
    List<LottoNumber> primaryNumbers = inputView.inputLottoNumberList();
    resultView.print("보너스 볼을 입력해 주세요.");
    LottoNumber bonusNumber = LottoNumber.of(inputView.inputInteger());
    resultView.printLottoResult(lottoMachine.getLottoResult(new WinNumbers(primaryNumbers, bonusNumber)));
  }
}
