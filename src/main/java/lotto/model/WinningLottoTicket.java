package lotto.model;

import java.util.List;

public class WinningLottoTicket extends LottoTicket {

    private WinningLottoTicket(final List<Integer> numbers) {
        super(numbers);
    }

    public static WinningLottoTicket newInstance(List<Integer> numbers) {
        return new WinningLottoTicket(numbers);
    }
}
