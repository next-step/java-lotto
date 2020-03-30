package lotto.model;

import lotto.model.wrapper.LottoNumber;

import java.util.Set;

public class WinningLottoTicket extends LottoTicket {

    private final LottoNumber bonusNumber;

    private WinningLottoTicket(final Set<LottoNumber> numbers, final LottoNumber bonusNumber) {
        super(numbers);
        this.bonusNumber = bonusNumber;
    }

    public static WinningLottoTicket newInstance(final Set<LottoNumber> numbers, LottoNumber bonusNumber) {
        return new WinningLottoTicket(numbers, bonusNumber);
    }

    public static Object create(Set<LottoNumber> lottoNumbers, LottoNumber bonusNumber) {
        return new WinningLottoTicket(lottoNumbers, bonusNumber);
    }
}
