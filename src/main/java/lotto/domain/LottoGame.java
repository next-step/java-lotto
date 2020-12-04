package lotto.domain;

import lotto.util.LottoUtil;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;
import java.util.stream.Collectors;

public class LottoGame {
    public void run() {
        InputMoney money = new InputMoney(InputView.inputMoney());
        Ticket ticket = new Ticket(money);
        List<String> textManualLottos = InputView.inputManualLotto();
        ticket.setManualCount(textManualLottos.size());

        List<Lotto> myLottoList = createManualLotto(textManualLottos);
        myLottoList.addAll(LottoUtil.createAutoLottoList(ticket));
        ResultView.printBuyLotto(ticket);
        ResultView.printLotto(myLottoList);

        WinningResult winningResult = new WinningResult(InputView.inputWinningNumber(), InputView.inputBonusBall());
        ResultView.printWinningStatistics(money, myLottoList, winningResult);
    }

    private List<Lotto> createManualLotto(List<String> textManualLottos) {
        return textManualLottos.stream()
                .map(LottoUtil::initTextToLotto)
                .collect(Collectors.toList());
    }

}
