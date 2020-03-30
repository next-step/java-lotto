package lotto.model;

import lotto.AutomaticLottoGenerator;
import lotto.model.wrapper.LottoNumber;

import java.util.Set;

public class LottoPurchaseTicket extends LottoTicket {

    private LottoPurchaseTicket(final Set<LottoNumber> numbers) {
        super(numbers);
    }

    public static LottoPurchaseTicket newInstance() {
        return new LottoPurchaseTicket(AutomaticLottoGenerator.generate());
    }

    public static LottoPurchaseTicket newInstance(final Set<LottoNumber> numbers) {
        return new LottoPurchaseTicket(numbers);
    }

    public LottoResult check(final WinningLottoTicket winningLottoTicket) {
        return winningLottoTicket.checkLottoTicket(numbers);
    }
}
