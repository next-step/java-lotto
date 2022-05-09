package lotto;

import lotto.model.LottoController;
import lotto.model.LottoResult;
import lotto.model.LottoTicket;
import lotto.model.RandomLottoTicketGenerator;
import lotto.view.Input;
import lotto.view.Output;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            LottoController lottoController = new LottoController();

            int money = Input.readMoney();
            int ticketCnt = lottoController.calculateTicketCnt(money);
            Output.printLottoCnt(ticketCnt);

            List<LottoTicket> lottoTickets = lottoController.generateTickets(ticketCnt, new RandomLottoTicketGenerator());
            Output.printLottoTicketList(lottoTickets);

            LottoTicket preWinningLottoTicket =  Input.readPreWeekWinningLottoNums();

            LottoResult lottoResult = lottoController.start(lottoTickets, preWinningLottoTicket);
            Output.printWinningStatics(money, lottoResult);
        }catch (Exception exception){
            System.out.println(String.join("\n", "ERROR", exception.getMessage()));
        }
    }
}
