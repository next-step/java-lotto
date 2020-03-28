package lotto.model;

import java.util.Arrays;
import java.util.List;

public class LottoPurchaseTicket extends LottoTicket {

    private LottoPurchaseTicket(final List<Integer> numbers) {
        super(numbers);
    }

    public static LottoPurchaseTicket newInstance(List<Integer> numbers) {
        return new LottoPurchaseTicket(numbers);
    }

    public LottoResult check(WinningLottoTicket winningLottoTicket) {
        int count = (int) Arrays.stream(winningLottoTicket.toArray())
                .filter(number -> numbers.contains(number))
                .count();
        return LottoResult.of(count);
    }
}
