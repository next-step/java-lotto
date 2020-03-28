package lotto.model;

import java.util.List;

public class WinningLottoTicket extends LottoTicket {

    private WinningLottoTicket(final List<LottoNumber> numbers) {
        super(numbers);
    }

    public static WinningLottoTicket newInstance(List<LottoNumber> numbers) {
        return new WinningLottoTicket(numbers);
    }
}
