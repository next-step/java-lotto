package lotto.controller;

import lotto.domain.*;
import lotto.domain.strategy.ManualGenerateStrategy;
import lotto.domain.strategy.RandomGenerateStrategy;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class LottoGameController {

    private final InputView inputView;
    private final OutputView outputView;
    private final LottoTicketMachine ticketMachine;

    public LottoGameController(InputView inputView, OutputView outputView, LottoTicketMachine ticketMachine) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.ticketMachine = ticketMachine;
    }

    public LottoGameController() {
        this(new InputView(), new OutputView(), new LottoTicketMachine());
    }

    public void play() {
        try {
            Money money = getMoney();
            List<LottoTicket> lottoTickets = getLottoTickets(money);
            outputView.printLottoTickets(lottoTickets);
            RankResults rankResults = getRankResults(lottoTickets);
            outputView.printResult(rankResults, money);
        } catch (RuntimeException e) {
            outputView.printErrorMessage(e.getMessage());
        }
    }

    private RankResults getRankResults(List<LottoTicket> lottoTickets) {
        WinningTicket winningTicket = getWinningTicket();
        List<Rank> ranks = getRanks(lottoTickets, winningTicket);
        return new RankResults(Ranks.getRankResults(ranks));
    }

    private WinningTicket getWinningTicket() {
        Set<LottoNumber> winningNumbers = inputView.readLottoNumbers();
        LottoNumber bonusNumber = inputView.readBonusNumber();
        return ticketMachine.generateWinningTicket(winningNumbers, bonusNumber);
    }

    private List<Rank> getRanks(List<LottoTicket> lottoTickets, WinningTicket winningTicket) {
        return lottoTickets.stream()
                .map(winningTicket::getRank)
                .collect(Collectors.toList());
    }

    private List<LottoTicket> getLottoTickets(Money money) {
        Money manualTicketPrice = inputView.readManualTicketPrice();
        Money randomTicketPrice = money.subtract(manualTicketPrice);

        return getTotalLottoTickets(manualTicketPrice, randomTicketPrice);
    }

    private ArrayList<LottoTicket> getTotalLottoTickets(Money manualTicketPrice, Money randomTicketPrice) {

        outputView.printManualTicketNumberMessage();

        ArrayList<LottoTicket> totalLottoTickets = new ArrayList<>();
        List<LottoTicket> manualLottoTickets = getManualLottoTickets(manualTicketPrice);
        List<LottoTicket> randomLottoTickets = getRandomLottoTickets(randomTicketPrice);

        outputView.printTicketCount(manualLottoTickets.size(), randomLottoTickets.size());

        totalLottoTickets.addAll(manualLottoTickets);
        totalLottoTickets.addAll(randomLottoTickets);

        return totalLottoTickets;
    }

    private List<LottoTicket> getRandomLottoTickets(Money randomTicketPrice) {
        return ticketMachine.buyLottoTickets(randomTicketPrice, new RandomGenerateStrategy());
    }

    private List<LottoTicket> getManualLottoTickets(Money manualTicketPrice) {
        return ticketMachine.buyLottoTickets(manualTicketPrice, new ManualGenerateStrategy());
    }

    private Money getMoney() {
        return inputView.readMoney();
    }
}

