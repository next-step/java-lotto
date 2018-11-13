package lotto;

import lotto.domain.*;
import lotto.domain.lottoMachine.LottoMachineFactory;
import lotto.view.InputView;
import lotto.view.ResultView;

public class ConsoleMain {

    public static void main(String[] args) {
        LottoRequest lottoRequest = InputView.inputTryLottoRequest();

        LottoStore lottoStore = new LottoStore(new LottoMachineFactory());
        LottoTicket lottoTicket = lottoStore.buyTickets(lottoRequest);
        
        ResultView.renderBuyedTickets(lottoTicket);

        WInningLottoRequest wInningLottoRequest = InputView.inputTryWinningLottoRequest();
        LottoResult lottoResult = lottoStore.checkWinningLotto(wInningLottoRequest, lottoTicket);
        
        ResultView.renderStats(lottoRequest.getMoney(), lottoResult);
    }
}
