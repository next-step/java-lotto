package step2step3.lotto;

import java.util.List;
import java.util.Objects;

import static java.util.stream.Collectors.toList;

public class LottoTickets {

    private final List<LottoTicket> lottoTickets;

    private final int lottoPrice;

    public LottoTickets(List<LottoTicket> lottoTickets, int lottoPrice) {
        this.lottoTickets = lottoTickets;
        this.lottoPrice = lottoPrice;
    }

    public int numberOfTickets() {
        return lottoTickets.size();
    }

    public void printNumbers(OutputDevice outputDevice) {
        lottoTickets.forEach(lottoTicket -> lottoTicket.printNumbers(outputDevice));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoTickets that = (LottoTickets) o;
        return Objects.equals(lottoTickets, that.lottoTickets);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoTickets);
    }

    public YieldCalculator yieldCalculator(WinningLottoInformation winningLottoInformation) {
        return new YieldCalculator(lottoPrice, matchedRanks(winningLottoInformation));
    }

    private List<Rank> matchedRanks(WinningLottoInformation winningLottoInformation) {
        return lottoTickets.stream()
                .map(winningLottoInformation::matchedRank)
                .collect(toList());
    }

    public MatchIndicatorCalculator matchIndicatorCalculator(WinningLottoInformation winningLottoInformation) {
        return new MatchIndicatorCalculator(matchedRanks(winningLottoInformation));
    }
}

