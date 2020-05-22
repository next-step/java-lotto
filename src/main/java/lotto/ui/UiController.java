package lotto.ui;

import lotto.application.LottoService;
import lotto.domain.lotto.LottoNumber;
import lotto.domain.lotto.LottoTicket;
import lotto.domain.lotto.LottoTickets;
import lotto.domain.rank.Ranks;
import lotto.domain.shop.Money;

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
        PrizeInputView prizeInputView = PrizeInputView.getThisWeekWinningNumbers(prizeInputScanner);
        LottoTicket winTicket = prizeInputView.convertToWinTicket();
        // TODO: 임의의 보너스 번호 추가 향후 InputView 에서 바꿀 것
        Ranks ranks = lottoService.calculateRank(winTicket, LottoNumber.create(3), lottoTickets);

        PrizeOutputView prizeOutputView = new PrizeOutputView(ranks);
        prizeOutputView.printPrizeStatistics(boughtMoneyValue);
    }
}
