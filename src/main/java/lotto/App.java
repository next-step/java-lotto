package lotto;

import lotto.domain.LottoNumber;
import lotto.domain.LottoTicket;
import lotto.domain.UserLottoTickets;
import lotto.domain.WiningLottoTicket;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class App {
    public static void main(String[] args) {

        //구입금액 입력
        int amount = InputView.getAmount();

        //수동으로 구매할 로또 수를 입력해 주세요.
        int manualTicketCount = InputView.getManualTicketCount();
        Money money = new Money(amount, manualTicketCount);

        //수동으로 구매할 번호를 입력해 주세요.
        String[] manualTicketNumbers = InputView.getManualTicketNumber(money.getManualTicketCount());

        List<LottoTicket> manualTickets = StringParseUtils.parseToLottoTickets(manualTicketNumbers);

        //수동 자동 티켓 구매수 출력
        OutputView.printTicketCount(money);

        LottoMachine lottoMachine = new LottoMachine(new UserLottoTicketGenerator());

        UserLottoTickets buyLottoTickets = lottoMachine.buyLottoTicket(money,manualTickets);

        ////수동으로  + 자동 구매 티켓 번호 출력
        OutputView.printBuyLottoTickets(buyLottoTickets);

        //지난주번호 입력
        LottoTicket winningNumber = StringParseUtils.parseToLottoTicket(InputView.getWinningNumber());

        //보너스넘버 입력
        LottoNumber bonusBall = InputView.getBonusNumber();

        //위닝로또
        WiningLottoTicket winingLottoTicket = new WiningLottoTicket(winningNumber, bonusBall);

        //결과저장, 비교
        LotteryResults lotteryResults = new LotteryResults(winingLottoTicket, buyLottoTickets);

        OutputView.printLotteryResult(lotteryResults);

        OutputView.printProfit(money.getProfit(lotteryResults));

    }
}
