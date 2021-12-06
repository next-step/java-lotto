package lotto.dto;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.WonLotto;

/**
 * @author han
 */
public class WonLottoDto {
    private final Lotto wonNumbers;
    private final LottoNumber bonusNumber;

    public WonLottoDto(String wonNumbers, String bonusNumber) {
        this.wonNumbers = new Lotto(wonNumbers);
        this.bonusNumber = new LottoNumber(bonusNumber);
    }

    public WonLotto toWonLotto() {
        return WonLotto.of(wonNumbers, bonusNumber);
    }
}
