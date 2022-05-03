package lotto.controller;

import lotto.domain.LottoTicket;
import lotto.domain.LottoTicketGenerator;
import lotto.domain.RankResults;
import lotto.domain.Ranks;
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
        this(new InputView(), new OutputView(), new LottoTicketGenerator());
    }

    public void play() {
        int money = getMoney();
        List<LottoTicket> lottoTickets = getLottoTickets(money);
        outputView.printLottoTickets(lottoTickets);
        RankResults rankResults = getRankResults(lottoTickets);
        outputView.printResult(rankResults, money);
    }

    private RankResults getRankResults(List<LottoTicket> lottoTickets) {
        LottoTicket winningTicket = getWinningTicket();
        List<Integer> matchNumbers = getMatchNumbers(lottoTickets, winningTicket);
        return new RankResults(Ranks.getRankResults(matchNumbers));
    }

    private LottoTicket getWinningTicket() {
        List<Integer> integers = inputView.readWinningNumber();
        return lottoTicketGenerator.generateWinningTicket(integers);
    }

    private List<Integer> getMatchNumbers(List<LottoTicket> lottoTickets, LottoTicket winningTicket) {
        return lottoTickets.stream()
                .map(t -> t.countMatchNumbers(winningTicket))
                .collect(Collectors.toList());
    }

    private List<LottoTicket> getLottoTickets(int money) {
        return lottoTicketGenerator.buyLottoTickets(money);
    }

    private int getMoney() {
        return inputView.readMoney().intValue();
    }
}

