package lotto.model;

import lotto.AutomaticLottoGenerator;
import lotto.model.wrapper.LottoMatchCount;
import lotto.model.wrapper.LottoNumber;

import java.util.Set;

public class LottoPurchaseTicket extends LottoTicket {

    private LottoPurchaseTicket(final Set<LottoNumber> numbers) {
        super(numbers);
    }

    public static LottoPurchaseTicket newInstance() {
        return new LottoPurchaseTicket(AutomaticLottoGenerator.generate());
    }

    public static LottoPurchaseTicket newInstance(Set<LottoNumber> numbers) {
        return new LottoPurchaseTicket(numbers);
    }

    public LottoResult check(WinningLottoTicket winningLottoTicket) {
        long count = winningLottoTicket.getNumbers()
                .stream()
                .filter(number -> numbers.contains(number))
                .count();

        boolean matchBonusNumber = numbers.contains(winningLottoTicket.getBonusNumber());

        return LottoResult.of(LottoMatchCount.create(Math.toIntExact(count), matchBonusNumber));
    }
}
