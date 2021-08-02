package lotto.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.model.LottoMoney;
import lotto.domain.model.LottoResult;
import lotto.domain.model.LottoTicket;
import lotto.domain.model.LottoTickets;
import lotto.domain.service.LottoService;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoController {

    public static final String COMMA_SPACE_DELIMITER = ",\\s*";

    private final LottoTickets userTickets;
    private final LottoTicket winningTicket;
    private final LottoMoney lottoMoney;

    public LottoController(LottoTickets userTickets, LottoTicket winningTicket,
            LottoMoney lottoMoney) {
        this.userTickets = userTickets;
        this.winningTicket = winningTicket;
        this.lottoMoney = lottoMoney;
    }

    public static LottoController createFromUserInput() {
        LottoMoney lottoMoney = lottoMoneyInput();
        LottoTickets randomTickets = createTicketsFromUserAmount(lottoMoney);
        ResultView.printLottoTickets(randomTickets);
        LottoTicket winningTicket = createWinningLottoFromInput();
        return new LottoController(randomTickets, winningTicket, lottoMoney);
    }

    private static LottoTickets createTicketsFromUserAmount(LottoMoney lottoMoney) {
        return LottoService.createRandomTickets(lottoMoney);
    }

    private static LottoMoney lottoMoneyInput() {
        int amount = InputView.askHowMuch();
        return LottoMoney.of(amount);
    }

    private static LottoTicket createWinningLottoFromInput() {
        String text = InputView.askForWinningLotto();
        String[] tokens = text.split(COMMA_SPACE_DELIMITER);
        List<Integer> numbers = Arrays.stream(tokens).map(Integer::parseInt)
                .collect(Collectors.toList());
        return LottoTicket.createFromList(numbers);
    }

    public void run() {
        LottoResult lottoResult = userTickets.match(winningTicket);
        ResultView.printLottoResult(lottoResult);
        double profitPercent = LottoService.profitPercent(lottoResult, lottoMoney);
        ResultView.printProfitPercent(profitPercent);
    }
}
