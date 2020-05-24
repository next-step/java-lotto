package lotto;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class LottoAnalyzer {

    private LottoGame lottoGame;

    public LottoAnalyzer(LottoGame lottoGame) {
        this.lottoGame = lottoGame;
    }

    public int matchingCount(int round, LottoTicket lottoTicket) {

        List<Integer> winningNumbers = lottoGame.get(round);

        if(Objects.isNull(winningNumbers)) {
            throw new IllegalArgumentException("존재하지 않는 회차입니다.");
        }

        return (int)lottoTicket.getLottoNumbers()
                .stream()
                .filter(winningNumbers::contains)
                .count();
    }

    public List<LottoRank> gradeTicketRank(int round, List<LottoTicket> lottoTickets){
        return lottoTickets.stream()
                .map(lottoTicket -> matchingCount(round, lottoTicket))
                .map(LottoRank::valueOf)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    public double revenueRate(int round, List<LottoTicket> lottoTickets) {
        long sum = gradeTicketRank(round, lottoTickets)
                .stream()
                .map(LottoRank::getPrice)
                .map(BigDecimal::longValue)
                .reduce(Long::sum)
                .get();

        return sum / (lottoTickets.size() * 1000.0);
    }
}
