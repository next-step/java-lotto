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

        WinningLotto winningLotto = lottoGame.get(round);

        if(Objects.isNull(winningLotto)) {
            throw new IllegalArgumentException("존재하지 않는 회차입니다.");
        }

        return (int)lottoTicket.getLottoNumbers()
                .stream()
                .filter(winningLotto::contains)
                .count();
    }

    public List<LottoRank> gradeTicket(int round, List<LottoTicket> lottoTickets){
        return lottoTickets.stream()
                .map(lottoTicket -> matchingCount(round, lottoTicket))
                .map(LottoRank::valueOf)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    public double calculateRevenueRate(int round, List<LottoTicket> lottoTickets) {
        long sum = gradeTicket(round, lottoTickets)
                .stream()
                .map(LottoRank::getPrice)
                .map(BigDecimal::longValue)
                .reduce(Long::sum)
                .get();

        return sum / (lottoTickets.size() * 1000.0);
    }
}
