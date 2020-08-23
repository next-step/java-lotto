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
        BuyCount totalBuyCount = BuyCount.fromMoney(InputView.scanLottoMoney());
        BuyCount selectBuyCount = BuyCount.from(InputView.scanSelectLottoBuyCount());

        List<String> lottoNumbers = InputView.scanLottoNumbers(selectBuyCount.get());

        LottoTickets selectLottoTickets
                = LottoTickets.of(selectBuyCount, new LottoTicketSelectMaker(lottoNumbers));
        LottoTickets autoLottoTickets
                = LottoTickets.of(totalBuyCount.subtract(selectLottoTickets.getSize()), new LottoTicketRandomMaker());
        LottoTickets totalLottoTickets = LottoTickets.merge(selectLottoTickets, autoLottoTickets);

        OutputView.printLottoTicketsCount(selectLottoTickets.getSize(), autoLottoTickets.getSize());
        OutputView.printLottoTickets(totalLottoTickets);

        return totalLottoTickets;
    }
}
