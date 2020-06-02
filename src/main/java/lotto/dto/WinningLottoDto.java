package lotto.dto;

import lotto.domain.LottoNumber;
import lotto.utils.LottoConverter;

import java.util.Set;

public class WinningLottoDto {

    private Set<LottoNumber> winningLottoNumber;
    private int bonusNumber;

    public WinningLottoDto(String winningLottoNumber, int bonusNumber) {
        this.winningLottoNumber = LottoConverter.convertToLottoNumber(winningLottoNumber);
        this.bonusNumber = bonusNumber;
    }

    public Set<LottoNumber> getWinningLottoNumber() {
        return winningLottoNumber;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
