package lotto_auto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class LottoBundle {

    private List<LottoTicket> lottoTicketList;

    public LottoBundle(int ticketCount) {
        throwIfNegativeTicketCount(ticketCount);
        this.lottoTicketList = Collections.unmodifiableList(
                IntStream.range(0, ticketCount)
                        .mapToObj(item -> new LottoTicket())
                        .collect(Collectors.toList())
        );
    }

    private void throwIfNegativeTicketCount(int ticketCount) {
        if (ticketCount <= 0) {
            throw new IllegalArgumentException();
        }
    }

    public int getTicketCount() {
        return lottoTicketList.size();
    }

    public List<LottoTicket> export() {
        return lottoTicketList;
    }

    public List<LottoResult> draw(LottoTicket winningLottoTicket) {
        List<LottoResult> ret = new ArrayList<>();
        for (LottoTicket lottoTicket : lottoTicketList) {
            LottoResult result = lottoTicket.draw(winningLottoTicket);
            ret.add(result);
        }
        return ret;
    }

}
