package lotto;

import lotto.domain.LottoNumber;
import lotto.domain.LottoTicket;
import lotto.domain.UserLottoTickets;
import lotto.domain.WiningLottoTicket;
import lotto.view.InputView;
import lotto.view.OutputView;

public class App {
    public static void main(String[] args) {

        Money money = new Money(InputView.getAmount());

        OutputView.printTicketCount(money);

        LottoMachine lottoMachine = new LottoMachine(new UserLottoTicketGenerator());

        UserLottoTickets buyLottoTickets = lottoMachine.buyLottoTicket(money);

        //랜덤값출력
        OutputView.printBuyLottoTickets(buyLottoTickets);

        //지난주번호 입력
        LottoTicket winningNumber = StringParseUtils.parseToIntegerList(InputView.getWinningNumber());

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
