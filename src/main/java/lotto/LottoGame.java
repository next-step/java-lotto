package lotto;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoGame {

    public static void main(String[] args) {
        LottoMoney lottoMoney = new LottoMoney(InputView.inputMoney());
        LottoTicketCount lottoTicketCount = LottoTicketCount.getInstance(lottoMoney);

        LottoShop lottoShop = new LottoShop();
        PublishedLottoTicket publishedLottoTicket = lottoShop.buyLotto(lottoMoney, lottoTicketCount);

        OutputView.printPublishedLottoResult(lottoTicketCount, publishedLottoTicket);

        List<Integer> winningLottoNumbers = InputView.inputWinningLottoNumbers();
        LottoMachine lottoMachine = new LottoMachine();
        WinningLotto winningLotto = new WinningLotto.Builder()
                .winningLottoTicket(lottoMachine.createManualLottoNumbers(winningLottoNumbers))
                .bonusBall(InputView.inputBonusBall())
                .build();

        LottoResult lottoResult = LottoResult.getInstance();
        lottoResult.analyzeLottoRank(publishedLottoTicket.getPublishedLottoTicket(), winningLotto);

        OutputView.printLottoStatics(lottoResult, lottoResult.calculatePrizeRate(lottoMoney));
    }

}
