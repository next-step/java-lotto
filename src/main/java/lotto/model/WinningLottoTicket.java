package lotto.model;

import lotto.model.wrapper.LottoNumber;
import lotto.model.wrapper.LottoResultMatchId;

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
            throw new IllegalArgumentException("보너스 숫자는 당첨 번호와 일치하면 안됩니다.");
        }

        return new WinningLottoTicket(LottoTicket.newInstance(numbers), bonusNumber);
    }

    public LottoResult check(LottoTicket lottoTicket) {
        long count = winningLottoTicket.getNumbers()
                .stream()
                .filter(lottoTicket::contains)
                .count();
        boolean matchBonusNumber = lottoTicket.contains(bonusNumber);

        return LottoResult.of(LottoResultMatchId.newInstance(Math.toIntExact(count), matchBonusNumber));
    }
}
