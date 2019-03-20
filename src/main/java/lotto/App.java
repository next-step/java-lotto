package lotto;

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
        List<Integer> winningNumber = Utils.parseToIntegerList(InputView.getWinningNumber());

        WiningLottoTicket winingLottoTicket = new WiningLottoTicket(winningNumber);
        //결과저장, 비교
        LotteryResults lotteryResults = new LotteryResults(winingLottoTicket, buyLottoTickets, amount);

        OutputView.printLotteryResult(lotteryResults);

    }
}
