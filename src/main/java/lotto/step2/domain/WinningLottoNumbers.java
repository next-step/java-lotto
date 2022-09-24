package lotto.step2.domain;

import java.util.List;

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
}
