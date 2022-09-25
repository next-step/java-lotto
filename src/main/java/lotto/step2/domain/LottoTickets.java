package lotto.step2.domain;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class LottoTickets {
    private static final int WINNING_MIN_MATCH_NUMBER = 3;
    
    private final List<LottoTicket> issueLottoTickets;
    
    public LottoTickets(List<LottoTicket> issueLottoTickets) {
        this.issueLottoTickets = issueLottoTickets;
    }
    
    public List<MatchNumber> numberOfMatches(WinningLottoNumbers winningLottoNumbers) {
        return issueLottoTickets.stream()
                .mapToInt(lottoTicket -> lottoTicket.confirmNumberMatch(winningLottoNumbers))
                .filter(matchNumber -> matchNumber >= WINNING_MIN_MATCH_NUMBER)
                .mapToObj(matchNumber -> MatchNumber.values()[matchNumber - WINNING_MIN_MATCH_NUMBER])
                .collect(Collectors.toList());
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoTickets that = (LottoTickets) o;
        return Objects.equals(issueLottoTickets, that.issueLottoTickets);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(issueLottoTickets);
    }
    
    @Override
    public String toString() {
        return issueLottoTickets.stream()
                .map(LottoTicket::toString)
                .collect(Collectors.joining("\n"));
    }
}
