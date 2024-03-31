package auto_lotto.controller;

import auto_lotto.domain.LottoTicket;
import auto_lotto.domain.LottoVendingMachine;
import auto_lotto.domain.WinningInfo;
import auto_lotto.view.InputView;
import auto_lotto.view.ResultView;

import java.util.List;
import java.util.Map;

public class LottoController {

    public static void main(String[] args) {
        InputView input = new InputView();
        ResultView output = new ResultView();
        LottoVendingMachine lottoMachine = new LottoVendingMachine();

        output.purchaseLotto();
        int money = input.inputMoney();

        List<LottoTicket> lottoTickets = lottoMachine.receive(money);
        output.printReceive(lottoTickets.size());
        output.printLotto(lottoTickets);

        output.printWinningLotto();
        List<Integer> inputLottoNumber = input.inputLottoNumber();
        Map<WinningInfo, Long> result = lottoMachine.checkIfWinningEntry(lottoTickets, inputLottoNumber);

        output.printWinningInfos(result, money);
    }
}
