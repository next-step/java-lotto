package lotto.model;

import lotto.AutomaticLottoGenerator;

import java.util.List;

public class LottoPurchaseTicket extends LottoTicket {

    private LottoPurchaseTicket(final List<LottoNumber> numbers) {
        super(numbers);
    }

    public static LottoPurchaseTicket newInstance() {
        return new LottoPurchaseTicket(AutomaticLottoGenerator.generate());
    }

    public static LottoPurchaseTicket newInstance(List<LottoNumber> numbers) {
        return new LottoPurchaseTicket(numbers);
    }

    public LottoResult check(WinningLottoTicket winningLottoTicket) {
        long count = winningLottoTicket.getNumbers()
                .stream()
                .filter(number -> numbers.contains(number))
                .count();
        return LottoResult.of(Math.toIntExact(count));
    }
}
