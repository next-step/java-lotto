package lotto.step2.domain;

import lotto.step2.dto.LottoTicketsDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LottoTickets {
    private final List<LottoTicket> lottoTickets;
    
    public LottoTickets(List<LottoTicket> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }
    
    public List<LottoRank> parseLottoRanks(WinningLottoNumbers winningLottoNumbers) {
        List<LottoRank> lottoRanks = new ArrayList<>();
        
        for (LottoTicket lottoTicket : lottoTickets) {
            lottoRanks.add(getLottoRank(winningLottoNumbers, lottoTicket));
        }
        return lottoRanks;
    }
    
    private LottoRank getLottoRank(WinningLottoNumbers winningLottoNumbers, LottoTicket lottoTicket) {
        int countMatchingNumber = lottoTicket.countMatchingNumber(winningLottoNumbers);
        boolean isExistBonusLottoNumber = lottoTicket.isExistBonusLottoNumber(winningLottoNumbers);
        return LottoRank.valueOf(countMatchingNumber, isExistBonusLottoNumber);
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
