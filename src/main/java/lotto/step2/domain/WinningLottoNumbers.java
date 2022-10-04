package lotto.step2.domain;

import java.util.List;

public class WinningLottoNumbers {
    private final List<LottoNumber> winningLottoNumbersInput;
    
    public WinningLottoNumbers(List<LottoNumber> winningLottoNumbersInput) {
        this.winningLottoNumbersInput = winningLottoNumbersInput;
    }
    
    public int countMatchingNumber(List<LottoNumber> lottoTicket) {
        return (int) lottoTicket.stream()
                .filter(winningLottoNumbersInput::contains)
                .count();
    }
}
