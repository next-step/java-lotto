package lotto.step2.domain;

import java.util.List;
import java.util.Objects;

public class WinningLottoNumbers {
    private final List<LottoNumber> winningLottoNumbers;
    
    public WinningLottoNumbers(List<LottoNumber> winningLottoNumbers) {
        this.winningLottoNumbers = winningLottoNumbers;
    }
    
    public int confirmNumberMatch(List<LottoNumber> lottoTicket) {
        return (int) winningLottoNumbers.stream()
                .filter(lottoTicket::contains)
                .count();
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WinningLottoNumbers that = (WinningLottoNumbers) o;
        return Objects.equals(winningLottoNumbers, that.winningLottoNumbers);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(winningLottoNumbers);
    }
}
