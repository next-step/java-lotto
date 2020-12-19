package lotto.controller;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoController {

    private LottoTicketCount lottoTicketCount;
    private PublishedLottoTicket publishedLottoTicket;

    public void startLottoGame() {
        LottoMoney lottoMoney = new LottoMoney(InputView.inputMoney());
        buyLottoTicket(lottoMoney);

        OutputView.printPublishedLottoResult(lottoTicketCount, publishedLottoTicket);

        LottoNumbers winningLottoNumbers = new LottoNumbers(InputView.inputWinningLottoNumbers());

        LottoMachine lottoMachine = LottoMachine.instance();
        WinningLotto winningLotto = new WinningLotto.Builder()
                .winningLottoTicket(lottoMachine.generateManualLottoNumbers(winningLottoNumbers))
                .bonusBall(InputView.inputBonusBall())
                .build();

        LottoDrawMachine lottoDrawMachine = new LottoDrawMachine();
        LottoResult lottoResult = lottoDrawMachine.drawLottoResult(winningLotto, publishedLottoTicket);

        OutputView.printLottoStatics(lottoResult, lottoResult.calculatePrizeRate(lottoMoney));
    }

    private void buyLottoTicket(LottoMoney lottoMoney) {
        int manualLottoCount = InputView.inputManualLottoCount();

        lottoTicketCount = new LottoTicketCount.Builder()
                .lottoMoney(lottoMoney)
                .manualLottoCount(manualLottoCount)
                .build();

        LottoShop lottoShop = new LottoShop();
        List<String> manualLottoNumbers = InputView.inputManualLottoNumbers(manualLottoCount);
        publishedLottoTicket = lottoShop.buyLotto(lottoTicketCount, manualLottoNumbers);
    }

}
