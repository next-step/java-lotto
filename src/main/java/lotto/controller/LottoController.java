package lotto.controller;

import java.math.BigDecimal;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.Lottos;
import lotto.domain.Rank;
import lotto.domain.Ticket;
import lotto.domain.WinningLotto;
import lotto.domain.WinningResult;
import lotto.domain.lottogenerator.RandomLottoGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private static final LottoController lottoController = new LottoController();

    private LottoController() {
    }

    public static LottoController getInstance() {
        return lottoController;
    }

    public void start() {
        Ticket ticket = getTicket();
        Lottos lottos = Lottos.withLottoGenerator(new RandomLottoGenerator(), ticket.getBuyCount());

        printTicketInfo(ticket, lottos);

        WinningLotto winningLotto = getWinningLotto();
        WinningResult winningResult = WinningResult.of(lottos, winningLotto);

        printResult(winningResult, ticket);
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
            Lotto winningLotto = Lotto.fromInputs(InputView.inputWinningNumbers());
            LottoNumber bonusNumber = LottoNumber.from(InputView.inputBonusNumber());
            return new WinningLotto(winningLotto, bonusNumber);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return getWinningLotto();
        }
    }

    private void printTicketInfo(Ticket ticket, Lottos lottos) {
        OutputView.printPurchaseInfo(ticket.getBuyCount(), lottos.getLottos());
    }

    private void printResult(WinningResult winningResult, Ticket ticket) {
        Map<Rank, Integer> result = winningResult.getResult();
        BigDecimal profitRate = winningResult.calculateProfitRate(ticket.getBuyCash());
        OutputView.printWinningResult(result, profitRate);
    }
}
