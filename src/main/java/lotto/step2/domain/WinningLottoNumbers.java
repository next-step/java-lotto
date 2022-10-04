package lotto.step2.domain;

import java.util.List;

public class WinningLottoNumbers {
    private static final String LOTTO_BONUS_NUMBER_INPUT_EXCEPTION_MESSAGE = "입력하신 보너스 번호는 이미 존재하는 당첨 번호 입니다. 다시 입력해주세요.";
    
    private final List<LottoNumber> winningLottoNumbersInput;
    private final LottoNumber bonusNumber;
    
    public WinningLottoNumbers(List<LottoNumber> winningLottoNumbersInput, LottoNumber bonusNumber) {
        if (winningLottoNumbersInput.contains(bonusNumber)) {
            throw new IllegalArgumentException(LOTTO_BONUS_NUMBER_INPUT_EXCEPTION_MESSAGE);
        }
        
        this.winningLottoNumbersInput = winningLottoNumbersInput;
        this.bonusNumber = bonusNumber;
    }
    
    public int countMatchingNumber(List<LottoNumber> lottoTicket) {
        return (int) lottoTicket.stream()
                .filter(winningLottoNumbersInput::contains)
                .count();
    }
    
    public boolean isExistBonusLottoNumber(List<LottoNumber> lottoTicket) {
        return lottoTicket.contains(bonusNumber);
    }
}
