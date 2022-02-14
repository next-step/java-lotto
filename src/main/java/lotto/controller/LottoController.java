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
import lotto.dto.LottosDTO;
import lotto.utils.Converter;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    public void start() {
        Ticket ticket = getTicket();
        Lottos lottos = Lottos.withLottoGenerator(new RandomLottoGenerator(), ticket.getBuyCount());

        printTicketInfo(ticket, lottos);

        WinningLotto winningLotto = getWinningLotto();
        WinningResult winningResult = new WinningResult(lottos.mapResult(winningLotto));

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
            Lotto winningLotto = Converter.inputToLotto(InputView.inputWinningNumbers());
            LottoNumber bonusNumber = LottoNumber.from(InputView.inputBonusNumber());
            return new WinningLotto(winningLotto, bonusNumber);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return getWinningLotto();
        }
    }

    private void printTicketInfo(Ticket ticket, Lottos lottos) {
        LottosDTO lottosDTO = LottosDTO.from(lottos.get());
        OutputView.printPurchaseInfo(ticket.getBuyCount(), lottosDTO.get());
    }

    private void printResult(WinningResult winningResult, Ticket ticket) {
        Map<Rank, Integer> result = winningResult.getResult();
        BigDecimal profitRate = winningResult.calculateProfitRate(ticket.getBuyCash());
        OutputView.printWinningResult(result, profitRate);
    }
}
