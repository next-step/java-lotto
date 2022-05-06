package lotto.controller;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;
import java.util.stream.Collectors;

public class LottoGameController {

    private final InputView inputView;
    private final OutputView outputView;
    private final LottoTicketGenerator lottoTicketGenerator;

    public LottoGameController(InputView inputView, OutputView outputView, LottoTicketGenerator lottoTicketGenerator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoTicketGenerator = lottoTicketGenerator;
    }

    public LottoGameController() {
        this(new InputView(), new OutputView(), new LottoTicketGenerator(new RandomGenerateStrategy()));
    }

    public void play() {
        int money = getMoney();
        List<LottoTicket> lottoTickets = getLottoTickets(money);
        outputView.printLottoTickets(lottoTickets);
        RankResults rankResults = getRankResults(lottoTickets);
        outputView.printResult(rankResults, money);
    }

    private RankResults getRankResults(List<LottoTicket> lottoTickets) {
        WinningTicket winningTicket = getWinningTicket();
        List<Rank> ranks = getRanks(lottoTickets, winningTicket);
        return new RankResults(Ranks.getRankResults(ranks));
    }

    private WinningTicket getWinningTicket() {
        List<Integer> integers = inputView.readWinningNumber();
        Integer bonusNumber = inputView.readBonusNumber();
        return lottoTicketGenerator.generateWinningTicket(integers, bonusNumber);
    }

    private List<Rank> getRanks(List<LottoTicket> lottoTickets, WinningTicket winningTicket) {
        return lottoTickets.stream()
                .map(winningTicket::getRank)
                .collect(Collectors.toList());
    }

    private List<LottoTicket> getLottoTickets(int money) {
        return lottoTicketGenerator.buyLottoTickets(money);
    }

    private int getMoney() {
        return inputView.readMoney().intValue();
    }
}

