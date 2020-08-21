package lotto;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class LottoController {

    public static void main(String[] args) {
        LottoTickets lottoTickets = getLottoTickets();
        OutputView.printLottoTickets(lottoTickets);

        WinningLotto winningLotto = WinningLotto.of(InputView.scanWinningLottoNumber(),
                                                    InputView.scanBonusNumber());
        WinningResult winningResult = lottoTickets.getWinningResult(winningLotto);
        OutputView.printLottoResult(winningResult);
    }

    private static LottoTickets getLottoTickets() {
        BuyCount buyCount = BuyCount.of(InputView.scanLottoMoney());
        int selectLottoBuyCount = InputView.scanSelectLottoBuyCount();

        List<String> lottoNumbers = InputView.scanLottoNumbers(selectLottoBuyCount);

        LottoTickets selectLottoTickets
                = LottoTickets.of(BuyCount.of(selectLottoBuyCount), new LottoTicketSelectMaker(lottoNumbers));
        LottoTickets autoLottoTickets = LottoTickets.of(buyCount, new LottoTicketRandomMaker());

        return LottoTickets.merge(selectLottoTickets, autoLottoTickets);
    }
}
