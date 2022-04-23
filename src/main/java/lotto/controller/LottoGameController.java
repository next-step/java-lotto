package lotto.controller;

import lotto.model.lotto.LottoGame;
import lotto.model.lotto.LottoNumber;
import lotto.model.lotto.LottoTicket;
import lotto.model.lotto.Money;
import lotto.model.lotto.strategy.RandomGenerationStrategy;
import lotto.model.rank.RankResults;
import lotto.model.lotto.TicketMachine;
import lotto.model.lotto.WinningTicket;
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
        List<LottoTicket> lottoTickets = ticketMachine.buyLottoTickets(money, new RandomGenerationStrategy());
        outputView.printTicketCount(lottoTickets.size());
        outputView.printLottoTickets(lottoTickets);
        return lottoTickets;
    }

}
