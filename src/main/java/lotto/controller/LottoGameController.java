package lotto.controller;

import lotto.model.lotto.LottoGame;
import lotto.model.lotto.LottoNumber;
import lotto.model.lotto.LottoTicket;
import lotto.model.lotto.Money;
import lotto.model.lotto.strategy.ManualGenerationStrategy;
import lotto.model.lotto.strategy.RandomGenerationStrategy;
import lotto.model.rank.RankResults;
import lotto.model.lotto.TicketMachine;
import lotto.model.lotto.WinningTicket;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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
        List<LottoTicket> lottoTickets = generateTotalLottoTickets(money);
        WinningTicket winningTicket = generateWinningTicket();
        return new LottoGame(lottoTickets, winningTicket);
    }

    private List<LottoTicket> generateTotalLottoTickets(Money money) {
        Money manualTicketPrice = inputView.readManualTicketPrice();
        Money randomTicketPrice = money.subtract(manualTicketPrice);

        outputView.printManualTicketNumbers();

        List<LottoTicket> totalLottoTickets = generateTotalLottoTickets(manualTicketPrice, randomTicketPrice);

        outputView.printLottoTickets(totalLottoTickets);

        return totalLottoTickets;
    }

    private WinningTicket generateWinningTicket() {
        Set<LottoNumber> winningNumbers = inputView.readLottoNumbers();
        LottoNumber bonusNumber = inputView.readBonusNumber();
        return ticketMachine.generateWinningTicket(winningNumbers, bonusNumber);
    }

    private List<LottoTicket> generateTotalLottoTickets(Money manualTicketPrice, Money randomTicketPrice) {
        List<LottoTicket> totalLottoTickets = new ArrayList<>();
        List<LottoTicket> manualLottoTickets = generateManualLottoTicket(manualTicketPrice);
        List<LottoTicket> randomLottoTickets = generateRandomLottoTickets(randomTicketPrice);

        outputView.printTicketCount(manualLottoTickets.size(), randomLottoTickets.size());

        totalLottoTickets.addAll(manualLottoTickets);
        totalLottoTickets.addAll(randomLottoTickets);

        return totalLottoTickets;
    }

    private List<LottoTicket> generateRandomLottoTickets(Money randomTicketPrice) {
        return ticketMachine.buyLottoTickets(randomTicketPrice, new RandomGenerationStrategy());
    }

    private List<LottoTicket> generateManualLottoTicket(Money manualTicketPrice) {
        return ticketMachine.buyLottoTickets(manualTicketPrice, new ManualGenerationStrategy());
    }

}
