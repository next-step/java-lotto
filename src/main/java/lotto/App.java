package lotto;

import lotto.domain.LottoTicket;
import lotto.domain.WiningLottoTicket;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class App {
    public static void main(String[] args) {

        int amount = InputView.getAmount();

        OutputView.printTicketCount(amount);

        LottoMachine lottoMachine = new LottoMachine(new UserLottoTicketGenerator());

        List<LottoTicket> buyLottoTickets = lottoMachine.buyLottoTicket(amount);

        //랜덤값출력
        OutputView.printBuyLottoTickets(buyLottoTickets);

        //지난주번호 입력
        List<Integer> winningNumber = StringParseUtils.parseToIntegerList(InputView.getWinningNumber());

        //보너스볼 입력
        int bonusBall = InputView.getBonusBall();

        //위닝로또
        WiningLottoTicket winingLottoTicket = new WiningLottoTicket(winningNumber, bonusBall);

        //결과저장, 비교
        LotteryResults lotteryResults = new LotteryResults(winingLottoTicket, buyLottoTickets, amount);


        OutputView.printLotteryResult(lotteryResults);

    }
}
