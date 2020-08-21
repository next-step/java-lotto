package lotto;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoController {

    public static void main(String[] args) {
        LottoTickets lottoTickets = getLottoTickets();
        WinningLotto winningLotto = WinningLotto.of(InputView.scanWinningLottoNumber(),
                                                    InputView.scanBonusNumber());
        WinningResult winningResult = lottoTickets.getWinningResult(winningLotto);
        OutputView.printLottoResult(winningResult);
    }

    private static LottoTickets getLottoTickets() {
        BuyCount totalBuyCount = BuyCount.of(InputView.scanLottoMoney());
        BuyCount selectBuyCount = BuyCount.of(InputView.scanSelectLottoBuyCount());

        List<String> lottoNumbers = InputView.scanLottoNumbers(selectBuyCount.get());

        LottoTickets selectLottoTickets
                = LottoTickets.of(selectBuyCount, new LottoTicketSelectMaker(lottoNumbers));
        LottoTickets autoLottoTickets
                = LottoTickets.of(totalBuyCount.subtract(selectLottoTickets.number()), new LottoTicketRandomMaker());
        LottoTickets totalLottoTickets = LottoTickets.merge(selectLottoTickets, autoLottoTickets);

        OutputView.printLottoTicketsCount(selectLottoTickets.number(), autoLottoTickets.number());
        OutputView.printLottoTickets(totalLottoTickets);

        return totalLottoTickets;
    }
}
