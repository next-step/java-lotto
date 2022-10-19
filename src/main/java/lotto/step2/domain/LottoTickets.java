package lotto.step2.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class LottoTickets {
    private List<LottoTicket> lottoTickets;
    
    public LottoTickets(List<LottoTicket> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }
    
    public List<LottoRank> parseLottoRanks(WinningLottoNumbers winningLottoNumbers) {
        List<LottoRank> lottoRanks = new ArrayList<>();
        
        for (LottoTicket lottoTicket : lottoTickets) {
            lottoRanks.add(parseLottoRank(winningLottoNumbers, lottoTicket));
        }
        return lottoRanks;
    }
    
    private LottoRank parseLottoRank(WinningLottoNumbers winningLottoNumbers, LottoTicket lottoTicket) {
        int countMatchingNumber = lottoTicket.countMatchingNumber(winningLottoNumbers);
        boolean isExistBonusLottoNumber = lottoTicket.isExistBonusLottoNumber(winningLottoNumbers);
        return LottoRank.valueOf(countMatchingNumber, isExistBonusLottoNumber);
    }
    
    public void mergeAutoLottos(final LottoTickets lottoTickets) {
        this.lottoTickets = new ArrayList<>(this.lottoTickets);
        this.lottoTickets.addAll(lottoTickets.lottoTickets);
    }
    
    public List<LottoTicket> getLottoTickets() {
        return Collections.unmodifiableList(lottoTickets);
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
