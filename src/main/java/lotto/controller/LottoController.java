package lotto.controller;

import static lotto.view.InputView.readBonusBall;
import static lotto.view.InputView.readCount;
import static lotto.view.InputView.readLottoMoney;
import static lotto.view.InputView.readLottos;
import static lotto.view.InputView.readWinningLotto;
import static lotto.view.OutputView.*;
import static lotto.view.OutputView.printPurchasedResult;

import lotto.model.*;
import lotto.model.dto.LottosDto;
import lotto.model.dto.WinningResultDto;

public class LottoController {

    public void run() {
        LottoMoney lottoMoney = new LottoMoney(readLottoMoney());
        Count manualCount = new Count(readCount());
        Lottos manualLottos = Lottos.createManualLottos(readLottos(manualCount.getCount()));

        Lottos lottoTicket = buyTicket(lottoMoney, manualCount, manualLottos);
        printPurchasedResult(LottosDto.from(lottoTicket));

        WinningResult winningResult = createWinningLotto(lottoMoney, lottoTicket);
        printWinningResult(WinningResultDto.from(winningResult));
    }

    private static Lottos buyTicket(final LottoMoney lottoMoney, final Count manualCount,
        final Lottos manualLotto) {
        LottoPurchaser lottoPurchaser = new LottoPurchaser(lottoMoney)
            .purchaseLotto(manualCount, manualLotto.getLottos());
        return new Lottos(lottoPurchaser.getPurchasedLottos());
    }

    private static WinningResult createWinningLotto(final LottoMoney lottoMoney,
        final Lottos ticket) {
        WinningLotto winningLotto = new WinningLotto(readWinningLotto(), readBonusBall());
        return new WinningResult(ticket.calculateMatchLotto(winningLotto), lottoMoney);
    }

}
