package lotto.controller;

import lotto.domain.Ticket;
import lotto.domain.WinningNumber;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoManager;
import lotto.domain.lotto.LottoNumber;
import lotto.domain.machine.RandomLottoGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    public void start() {
        Ticket ticket = buyTicket();

        LottoManager lottoManager = new LottoManager(new RandomLottoGenerator(),
            ticket.getBuyCount());

        OutputView.printPurchaseAmount(ticket.getBuyCount());
        OutputView.printPurchaseTicket(lottoManager.getLottos());

        WinningNumber winningNumber = makeWinningNumber();
    }

    public Ticket buyTicket() {
        int money = Integer.parseInt(InputView.writePurchaseAmount());
        return new Ticket(money);
    }

    private WinningNumber makeWinningNumber() {
        return new WinningNumber(makeSixNumbers(), makeBonusBall());
    }

    private Lotto makeSixNumbers() {
        try {
            return Lotto.from(InputView.writeWinningNumbers());
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return makeSixNumbers();
        }
    }

    private LottoNumber makeBonusBall() {
        try {
            return new LottoNumber(InputView.writeBonusBall());
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return makeBonusBall();
        }
    }
}
