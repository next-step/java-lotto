package lotto.domian;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoTickets {
   private final List<LottoTicket> lottoTickets;

    private LottoTickets(int ticketCount, LottoNumberGenerator generator){
        lottoTickets = IntStream.range(0, ticketCount)
                .mapToObj(i -> generator.generateRandomLottoNumbers())
                .map(LottoTicket::of)
                .collect(Collectors.toList());
    }

    public static LottoTickets of(int ticketCount, LottoNumberGenerator generator){
        return new LottoTickets(ticketCount, generator);
    }

    public void updateLottoResult(WinnerNumber winnerNumber, LottoResult lottoResult) {
        for (LottoTicket ticket : lottoTickets) {
            int matchCount = ticket.countMatchingNumbers(winnerNumber);
            LottoRank rank = LottoRank.valueOfMatchCount(matchCount);
            lottoResult.updateResultForRank(rank);
        }
    }

    public List<LottoTicket> getLottoTickets() {
        return lottoTickets;
    }

}
