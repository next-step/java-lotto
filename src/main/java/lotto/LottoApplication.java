package lotto;

import lotto.domain.LottoTicket;
import lotto.domain.LottoTicketGenerator;
import lotto.domain.RandomGenerateStrategy;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public class LottoApplication {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        BigDecimal bigDecimal = inputView.readMoney();
        int money = bigDecimal.intValue();
        LottoTicketGenerator lottoTicketGenerator = new LottoTicketGenerator(new RandomGenerateStrategy());
        List<LottoTicket> lottoTickets = lottoTicketGenerator.buyLottoTickets(money);
        OutputView outputView = new OutputView();
        outputView.printLottoTicketCount(lottoTickets.size());
        outputView.printLottoTickets(lottoTickets);

        List<Integer> integers = inputView.readWinningNumber();
        LottoTicket lottoTicket = lottoTicketGenerator.generateWinningTicket(integers);
        List<Integer> matchNumbers = lottoTickets.stream()
                .map(t -> t.countMatchNumbers(lottoTicket))
                .collect(Collectors.toList());
        outputView.printResult(matchNumbers, money);
    }
}
