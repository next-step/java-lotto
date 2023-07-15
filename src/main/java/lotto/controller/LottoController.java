package lotto.controller;

import static lotto.view.InputView.readBonusBall;
import static lotto.view.InputView.readCount;
import static lotto.view.InputView.readLottoMoney;
import static lotto.view.InputView.readLottos;
import static lotto.view.InputView.readWinningLotto;
import static lotto.view.OutputView.*;
import static lotto.view.OutputView.printPurchasedResult;

import java.util.List;
import lotto.model.*;
import lotto.model.dto.LottosDto;
import lotto.model.dto.WinningResultDto;

public class LottoController {

    public void run() {
        LottoMoney lottoMoney = new LottoMoney(readLottoMoney());
        Count manualCount = new Count(readCount());
        List<List<Integer>> manualLotto = readLottos(manualCount.getCount());

        Lottos lottoTicket = buyTicket(lottoMoney, manualCount, manualLotto);
        printPurchasedResult(LottosDto.from(lottoTicket));

        WinningResult winningResult = createWinningLotto(lottoMoney, lottoTicket);
        printWinningResult(WinningResultDto.from(winningResult));
    }

    private static Lottos buyTicket(final LottoMoney lottoMoney, final Count manualCount,
        final List<List<Integer>> manualLotto) {
        LottoPurchaser lottoPurchaser = new LottoPurchaser(lottoMoney).purchaseLotto(manualCount,
            manualLotto);
        return new Lottos(lottoPurchaser.getPurchasedLottos());
    }

    private static WinningResult createWinningLotto(final LottoMoney lottoMoney,
        final Lottos ticket) {
        WinningLotto winningLotto = new WinningLotto(readWinningLotto(), readBonusBall());
        return new WinningResult(ticket.calculateMatchLotto(winningLotto), lottoMoney);
    }

}
