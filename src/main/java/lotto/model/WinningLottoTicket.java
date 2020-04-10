package lotto.model;

import lotto.model.wrapper.LottoNumber;

import java.util.Set;

public class WinningLottoTicket {

    private final LottoTicket winningLottoTicket;
    private final LottoNumber bonusNumber;

    private WinningLottoTicket(final LottoTicket winningLottoTicket, final LottoNumber bonusNumber) {
        if (winningLottoTicket.contains(bonusNumber)) {
            throw new IllegalArgumentException("보너스 숫자는 당첨 번호와 일치하면 안됩니다.");
        }

        this.winningLottoTicket = winningLottoTicket;
        this.bonusNumber = bonusNumber;
    }

    public static WinningLottoTicket newInstance(final LottoTicket winningLottoTicket, final LottoNumber bonusNumber) {
        return new WinningLottoTicket(winningLottoTicket, bonusNumber);
    }

    public static WinningLottoTicket newInstance(final Set<LottoNumber> numbers, final LottoNumber bonusNumber) {
        return new WinningLottoTicket(LottoTicket.newInstance(numbers), bonusNumber);
    }

    public LottoWinningResult check(final LottoTicket lottoTicket) {
        long count = winningLottoTicket.getNumbers()
                .stream()
                .filter(lottoTicket::contains)
                .count();
        boolean matchBonusNumber = lottoTicket.contains(bonusNumber);

        return LottoWinningResult.of(Math.toIntExact(count), matchBonusNumber);
    }
}
