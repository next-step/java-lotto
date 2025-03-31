package lotto;

import java.util.List;
import java.util.Scanner;

import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import lotto.domain.WinningLotto;
import lotto.service.LottoCheckerService;
import lotto.view.InputView;
import lotto.view.OutputView;
import lotto.vo.LottoManualTicket;

public class Main {
    public static void main(String[] args) {
        InputView inputView = new InputView(new Scanner(System.in));
        int money = inputView.inputPurchaseAmount();
        int manualTicketCount = inputView.inputManualTicketCount();
        List<LottoManualTicket> manualTickets = inputView.inputManualTicket(manualTicketCount);

        LottoMachine machine = new LottoMachine(money, manualTickets);
        List<Lotto> lottos = machine.buyLottos();

        OutputView.printLottoCount(manualTicketCount, lottos.size());
        OutputView.printLottos(lottos);

        WinningLotto winningLotto = new WinningLotto(inputView.inputWinningNumbers(), inputView.inputBonusNumber());
        LottoCheckerService checker = new LottoCheckerService(winningLotto);
        OutputView.printWinningStatistics(money, checker.check(lottos));
    }
}
