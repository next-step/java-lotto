package lotto.model;

import lotto.model.wrapper.LottoNumber;

import java.util.Set;

public class WinningLottoTicket extends LottoTicket {

    private WinningLottoTicket(final Set<LottoNumber> numbers) {
        super(numbers);
    }

    public static WinningLottoTicket newInstance(final Set<LottoNumber> numbers) {
        return new WinningLottoTicket(numbers);
    }
}
