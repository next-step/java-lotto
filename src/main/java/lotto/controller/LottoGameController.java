package lotto.controller;

import lotto.model.LottoGame;
import lotto.model.LottoNumber;
import lotto.model.LottoTicket;
import lotto.model.Money;
import lotto.model.RankResults;
import lotto.model.TicketMachine;
import lotto.model.WinningTicket;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoGameController {

    private final InputView inputView;

    private final TicketMachine ticketMachine;

    private final OutputView outputView;

    public LottoGameController() {
        this(new InputView(), new TicketMachine(), new OutputView());
    }

    public LottoGameController(InputView inputView, TicketMachine ticketMachine, OutputView outputView) {
        this.inputView = inputView;
        this.ticketMachine = ticketMachine;
        this.outputView = outputView;
    }

    public void start() {
        try {
            Money money = inputView.readMoney();
            LottoGame lottoGame = generateLottoGame(money);
            RankResults rankResults = lottoGame.start();
            outputView.printLottoResults(rankResults, money);
        } catch (RuntimeException runtimeException) {
            outputView.printErrorMessage(runtimeException.getMessage());
        }
    }

    private LottoGame generateLottoGame(Money money) {
        List<LottoTicket> lottoTickets = generateLottoTickets(money);
        WinningTicket winningTicket = generateWinningTicket();
        return new LottoGame(lottoTickets, winningTicket);
    }

    private WinningTicket generateWinningTicket() {
        List<Integer> winningNumbers = inputView.readWinningNumbers();
        LottoNumber bonusNumber = inputView.readBonusNumber();
        return ticketMachine.generateWinningTicket(winningNumbers, bonusNumber);
    }

    private List<LottoTicket> generateLottoTickets(Money money) {
        List<LottoTicket> lottoTickets = ticketMachine.buyLottoTickets(money);
        outputView.printTicketCount(lottoTickets.size());
        outputView.printLottoTickets(lottoTickets);
        return lottoTickets;
    }

}
