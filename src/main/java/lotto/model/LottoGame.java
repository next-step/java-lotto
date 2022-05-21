package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {


    private static List<LottoTicket> generateLottoTicketList(int ticketCnt){
        List<LottoTicket> lottoTickets = new ArrayList<>();
        for (int i = 0; i < ticketCnt; i++) {
            LottoTicket lottoTicket = LottoNumber.generateLottoTicket();
            lottoTickets.add(lottoTicket);
        }
        return lottoTickets;
    }

    public static LottoTickets generateLottoTickets(List<LottoTicket> manualTicketList, Money money){
        int ticketCnt = money.calculateTicketCnt();
        int manualTicketCnt = manualTicketList.size();
        int autoTicketCnt = ticketCnt - manualTicketCnt;

        if(manualTicketCnt > ticketCnt){
            throw new IllegalArgumentException("생성가능한 수동 로또 티켓 개수를 초과햐였습니다.");
        }

        List<LottoTicket> autoLottoTicketList = generateLottoTicketList(autoTicketCnt);
        return new LottoTickets(manualTicketList, autoLottoTicketList);
    }
}
