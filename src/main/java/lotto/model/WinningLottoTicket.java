package lotto.model;

import lotto.model.wrapper.LottoNumber;

import java.util.List;

public class WinningLottoTicket extends LottoTicket {

    private WinningLottoTicket(final List<LottoNumber> numbers) {
        super(numbers);
    }

    public static WinningLottoTicket newInstance(List<LottoNumber> numbers) {
        return new WinningLottoTicket(numbers);
    }
}
