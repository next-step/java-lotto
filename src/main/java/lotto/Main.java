package lotto;

import lotto.model.*;
import lotto.view.Input;
import lotto.view.Output;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            LottoController lottoController = new LottoController();

            Money money = new Money(Input.readMoney());
            int ticketCnt = money.calculateTicketCnt();
            Output.printLottoCnt(ticketCnt);

            List<LottoTicket> lottoTicketList = lottoController.generateTickets(ticketCnt, new RandomLottoTicketGenerator());
            LottoTickets lottoTickets = new LottoTickets(lottoTicketList);
            Output.printLottoTicketList(lottoTicketList);

            LottoTicket preWinningLottoTicket =  Input.readPreWeekWinningLottoNums();
            LottoResult lottoResult = lottoController.start(lottoTickets, preWinningLottoTicket);
            Output.printWinningStatics(money, lottoResult);
        }catch (Exception exception){
            System.out.println(String.join("\n", "ERROR", exception.getMessage()));
        }
    }
}
