package lotto.step2.domain;

import java.util.List;
import java.util.Objects;

public class LottoTicket {
    private final List<LottoNumber> lottoTicket;
    
    public LottoTicket(List<LottoNumber> lottoTicket) {
        this.lottoTicket = lottoTicket;
    }
    
    public int confirmNumberMatch(WinningLottoNumbers winningLottoNumbers) {
        return winningLottoNumbers.confirmNumberMatch(lottoTicket);
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoTicket that = (LottoTicket) o;
        return Objects.equals(lottoTicket, that.lottoTicket);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(lottoTicket);
    }
}
