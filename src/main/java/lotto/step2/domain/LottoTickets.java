package lotto.step2.domain;

import lotto.step2.dto.LottoTicketsDTO;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class LottoTickets {
    private final List<LottoTicket> lottoTickets;
    
    public LottoTickets(List<LottoTicket> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }
    
    public List<LottoRank> lottoRanks(List<LottoNumber> winningLottoNumbers) {
        return lottoTickets.stream()
                .map(lottoTicket -> lottoTicket.countMatchingNumber(winningLottoNumbers))
                .map(LottoRank::valueOf)
                .collect(Collectors.toList());
    }
    
    public LottoTicketsDTO lottoTicketsInformation() {
        return new LottoTicketsDTO(lottoTickets);
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
}
