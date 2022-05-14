package lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

public class LottoTickets {

    private final List<LottoTicket> lottoTicketList;

    public LottoTickets(List<LottoTicket> lottoTicketList) {
        this.lottoTicketList = Collections.unmodifiableList(lottoTicketList);
    }

    public Map<Rank, Long> getRankMap(LottoTicket winningNumbers, LottoNumber bonusBall){
        Map<Rank, Long> res = lottoTicketList.stream()
                .map(ticket -> ticket.getRank(winningNumbers, bonusBall))
                .filter(Rank::isWin)
                .collect(groupingBy(Function.identity(), Collectors.counting()));
        return res;
    }

    public static List<LottoTicket> generateTickets(int ticketCnt){
        List<LottoTicket> lottoTickets = new ArrayList<>();
        for (int i = 0; i < ticketCnt; i++) {
            LottoTicket lottoTicket = LottoNumber.generateLottoTicket();
            lottoTickets.add(lottoTicket);
        }
        return lottoTickets;
    }
}
