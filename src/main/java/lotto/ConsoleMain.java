package lotto;

import lotto.domain.*;
import lotto.domain.lottoMachine.LottoMachineFactory;
import lotto.view.InputView;
import lotto.view.ResultView;

public class ConsoleMain {

    public static void main(String[] args) {
        Money won = Money.of(InputView.inputTryNo("구입금액을 입력해 주세요."));

        int tryManualLottoCount = InputView.inputTryNo("수동으로 구매할 로또 수를 입력해 주세요.");
        String[] manualLottoValues = InputView.inputTryLines("수동으로 구매할 번호를 입력해 주세요.", tryManualLottoCount);

        LottoRequest request = new LottoRequest(won, manualLottoValues);

        LottoStore lottoStore = new LottoStore(new LottoMachineFactory());
        LottoTicket lottoTicket = lottoStore.buyTickets(request);
        
        ResultView.renderBuyedTickets(lottoTicket);
        
        String winningNumber = InputView.inputTryLine("지난 주 당첨 번호를 입력해 주세요.");
        int bonusNumber = InputView.inputTryNo("보너스 볼을 입력해 주세요.");
        LottoResult lottoResult = lottoStore.checkWinningLotto(winningNumber, bonusNumber, lottoTicket);
        
        ResultView.renderStats(won, lottoResult);
    }
}
