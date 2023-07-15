package lotto.controller;

import java.util.List;
import lotto.model.*;
import lotto.model.dto.LottosDto;
import lotto.model.dto.WinningResultDto;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    public void run() {
        LottoMoney lottoMoney = new LottoMoney(InputView.readLottoMoney());
        Count manualCount = new Count(InputView.readCount());
        List<List<Integer>> manualLotto = InputView.readLottos(manualCount.getCount());

        Lottos lottoTicket = buyTicket(lottoMoney, manualCount, manualLotto);
        OutputView.printPurchasedResult(LottosDto.from(lottoTicket));

        WinningResult winningResult = createWinningLotto(lottoMoney, lottoTicket);
        OutputView.printWinningResult(WinningResultDto.from(winningResult));
    }

    private static Lottos buyTicket(LottoMoney lottoMoney, Count manualCount,
        List<List<Integer>> manualLotto) {
        LottoPurchaser lottoPurchaser = new LottoPurchaser(lottoMoney).purchaseLotto(manualCount,
            manualLotto);
        return new Lottos(lottoPurchaser.getPurchasedLottos());
    }

    private static WinningResult createWinningLotto(LottoMoney lottoMoney, Lottos ticket) {
        WinningLotto winningLotto = new WinningLotto(InputView.readWinningLotto(),
            InputView.readBonusBall());
        return new WinningResult(ticket.calculateMatchLotto(winningLotto), lottoMoney);
    }

}
