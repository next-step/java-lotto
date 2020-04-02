package lotto.model;

import lotto.model.wrapper.LottoMatchCount;
import lotto.model.wrapper.LottoNumber;

import java.util.Set;

public class WinningLottoTicket {

    private final LottoTicket winningLottoTicket;
    private final LottoNumber bonusNumber;

    private WinningLottoTicket(final LottoTicket winningLottoTicket, final LottoNumber bonusNumber) {
        this.winningLottoTicket = winningLottoTicket;
        this.bonusNumber = bonusNumber;
    }

    public static WinningLottoTicket newInstance(final Set<LottoNumber> numbers, final LottoNumber bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("bonus number must be distinct.");
        }

        return new WinningLottoTicket(LottoTicket.newInstance(numbers), bonusNumber);
    }

    public LottoResult check(LottoTicket lottoTicket) {
        long count = winningLottoTicket.getNumbers()
                .stream()
                .filter(lottoTicket::contains)
                .count();
        boolean matchBonusNumber = lottoTicket.contains(bonusNumber);

        return LottoResult.of(LottoMatchCount.create(Math.toIntExact(count), matchBonusNumber));
    }
}
