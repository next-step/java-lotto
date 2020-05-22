package lotto.ui;

import lotto.application.LottoService;
import lotto.domain.lotto.LottoTickets;
import lotto.domain.rank.Ranks;
import lotto.domain.shop.Money;

import java.util.List;
import java.util.Scanner;

public class UiController {
    public static void main(String[] args) {
        Scanner buyInputScanner = new Scanner(System.in);
        BuyInputView inputViewByConsole = BuyInputView.createByConsole(buyInputScanner);

        LottoService lottoService = new LottoService();
        long boughtMoneyValue = inputViewByConsole.getMoney();
        LottoTickets lottoTickets = lottoService.buyLottoTickets(new Money(boughtMoneyValue));

        BuyOutputView buyOutputView = new BuyOutputView(lottoTickets);
        buyOutputView.printResult();

        Scanner prizeInputScanner = new Scanner(System.in);
        PrizeInputView prizeInputView = PrizeInputView.create(prizeInputScanner);
        List<Integer> winnerTicketNumbers = prizeInputView.convertToIntCollection();
        Ranks ranks = lottoService.calculateRank(winnerTicketNumbers, lottoTickets);

        PrizeOutputView prizeOutputView = new PrizeOutputView(ranks);
        prizeOutputView.printPrizeStatistics(boughtMoneyValue);
    }
}
