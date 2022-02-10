package lotto.controller;

import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.Lottos;
import lotto.domain.Rank;
import lotto.domain.Ticket;
import lotto.domain.WinningLotto;
import lotto.domain.WinningResult;
import lotto.domain.lottogenerator.RandomLottoGenerator;
import lotto.dto.LottosDTO;
import lotto.utils.Converter;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    public void start() {
        Ticket ticket = getTicket();

        Lottos lottos = new Lottos(new RandomLottoGenerator(), ticket.getBuyCount());

        LottosDTO lottosDTO = LottosDTO.from(lottos.get());
        OutputView.printPurchaseInfo(ticket.getBuyCount(), lottosDTO.get());

        WinningLotto winningLotto = getWinningLotto();

        WinningResult winningResult = new WinningResult(winningLotto);
        Map<Rank, Integer> result = winningResult.mapResult(lottos.get());
        double profitRate = winningResult.calculateProfitRate(ticket.getBuyCash());

        OutputView.printWinningResult(result, profitRate);
    }

    private Ticket getTicket() {
        try {
            return new Ticket(InputView.inputBuyCash());
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return getTicket();
        }
    }

    private WinningLotto getWinningLotto() {
        try {
            Lotto winningLotto = Converter.inputToLotto(InputView.inputWinningNumbers());
            LottoNumber bonusNumber = new LottoNumber(InputView.inputBonusNumber());
            return new WinningLotto(winningLotto, bonusNumber);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return getWinningLotto();
        }
    }
}
