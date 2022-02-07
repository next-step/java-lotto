package lotto.controller;

import lotto.domain.Ticket;
import lotto.domain.WinningNumber;
import lotto.domain.WinningResult;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoRepository;
import lotto.domain.lotto.LottoNumber;
import lotto.domain.machine.RandomLottoGenerator;
import lotto.domain.rank.RankRepository;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    public void start() {
        OutputView outputView = new OutputView();
        Ticket ticket = buyTicket();

        LottoRepository lottoManager = new LottoRepository(new RandomLottoGenerator(),
            ticket.getBuyCount());

        outputView.printPurchaseAmount(ticket.getBuyCount());
        outputView.printPurchaseTicket(lottoManager.getLottos());

        WinningNumber winningNumber = makeWinningNumber();

        RankRepository ranks = RankRepository.getRanksOf(lottoManager, winningNumber);
        WinningResult winningResult = new WinningResult(ranks.getRanks());
        winningResult.calculateYield(ticket.getBuyCash());

        outputView.printWinningResult(winningResult);
    }

    public Ticket buyTicket() {
        int money = Integer.parseInt(InputView.writePurchaseAmount());
        return new Ticket(money);
    }

    private WinningNumber makeWinningNumber() {
        try {
            return new WinningNumber(makeSixNumbers(), makeBonusBall());
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return makeWinningNumber();
        }
    }

    private Lotto makeSixNumbers() {
        return Lotto.from(InputView.writeWinningNumbers());
    }

    private LottoNumber makeBonusBall() {
        return new LottoNumber(InputView.writeBonusBall());
    }
}
