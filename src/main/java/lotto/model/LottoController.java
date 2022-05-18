package lotto.model;

import lotto.view.Input;
import lotto.view.Output;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LottoController {

    public void start(){
        Money money = new Money(Input.readMoney());

        // 로또 티켓들 생성
        LottoTickets lottoTickets = getLottoTickets(money);

        // 지난 주 당첨 번호와 보너스볼
        LottoTicket winningTicket =  Input.readPreWeekWinningLottoNums();
        LottoNumber bonusBall = Input.readLottoNumber();

        Map<Rank, Long> rankMap = lottoTickets.getRankMap(winningTicket, bonusBall);
        LottoResult lottoResult = new LottoResult(rankMap);

        Output.printWinningStatics(money, lottoResult);
    }

    private LottoTickets getLottoTickets(Money money){
        int ticketCnt = getTicketCnt(money);

        int manualLottoCnt = Input.readManualLottoCnt();
        int autoLottoCnt = ticketCnt - manualLottoCnt;

        if(manualLottoCnt > ticketCnt){
            throw new IllegalArgumentException("수동으로 구매할 수 있는 로또 수를 초과하였습니다.");
        }

        // 로또 티켓들 생성
        return generateLottoTickets(manualLottoCnt, autoLottoCnt);
    }

    private int getTicketCnt(Money money) {
        int cnt = money.calculateTicketCnt();
        Output.printLottoCnt(cnt);
        return cnt;
    }

    private LottoTickets generateLottoTickets(int manualLottoCnt, int ticketCnt){
        List<LottoTicket> manualLottoTickets = Input.readManualLottoNumbers(manualLottoCnt);
        List<LottoTicket> autoLottoTickets = LottoTickets.generateTickets(ticketCnt);
        Output.printLottoTicketList(manualLottoTickets, autoLottoTickets);

        List<LottoTicket> mergedLottoTickets = new ArrayList<>();
        mergedLottoTickets.addAll(manualLottoTickets);
        mergedLottoTickets.addAll(autoLottoTickets);

        return new LottoTickets(mergedLottoTickets);
    }
}
