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

        int amount = InputView.getAmount();

        OutputView.printTicketCount(amount);

        LottoMachine lottoMachine = new LottoMachine(new UserLottoTicketGenerator());

        UserLottoTickets buyLottoTickets = lottoMachine.buyLottoTicket(amount);

        //랜덤값출력
        OutputView.printBuyLottoTickets(buyLottoTickets);

        //지난주번호 입력
        LottoTicket winningNumber = StringParseUtils.parseToIntegerList(InputView.getWinningNumber());

        //보너스넘버 입력
        LottoNumber bonusBall = InputView.getBonusNumber();;

        //위닝로또
        WiningLottoTicket winingLottoTicket = new WiningLottoTicket(winningNumber, bonusBall);

        //결과저장, 비교
        LotteryResults lotteryResults = new LotteryResults(winingLottoTicket, buyLottoTickets, amount);

        OutputView.printLotteryResult(lotteryResults);

    }
}
