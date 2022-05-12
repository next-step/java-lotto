package lotto.model;

import lotto.view.Input;
import lotto.view.Output;

import java.util.List;
import java.util.Map;

public class LottoController {

    public void start(){
        Money money = new Money(Input.readMoney());
        int ticketCnt = getTicketCnt(money);

        LottoTickets lottoTickets = generateLottoTickets(ticketCnt);
        LottoTicket winningTicket =  Input.readPreWeekWinningLottoNums();

        Map<Rank, Long> rankMap = lottoTickets.getRankMap(winningTicket);
        LottoResult lottoResult = new LottoResult(rankMap);

        Output.printWinningStatics(money, lottoResult);
    }

    private int getTicketCnt(Money money) {
        int cnt = money.calculateTicketCnt();
        Output.printLottoCnt(cnt);
        return cnt;
    }

    private LottoTickets generateLottoTickets(int ticketCnt){
        List<LottoTicket> lottoTicketList = LottoTickets.generateTickets(ticketCnt);
        Output.printLottoTicketList(lottoTicketList);
        return new LottoTickets(lottoTicketList);
    }
}
