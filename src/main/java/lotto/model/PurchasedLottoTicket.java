package lotto.model;

import java.util.List;
import lotto.utils.AutomaticLottoGenerator;

public class PurchasedLottoTicket extends LottoTicket {

    private PurchasedLottoTicket(final List<LottoNumber> lottoNumbers) {
        super(lottoNumbers);
    }

    public static PurchasedLottoTicket create() {
        return new PurchasedLottoTicket(AutomaticLottoGenerator.createLottoNumbers());
    }

    public LottoResult match(WinningLottoTicket winningLottoTicket) {
        long count = getMatchCount(winningLottoTicket);
        boolean isMatchLottoBonusNumber = isMatchLottoBonusNumber(winningLottoTicket);

        return LottoResult.of(LottoMatchCount.of(Math.toIntExact(count), isMatchLottoBonusNumber));
    }

    private long getMatchCount(WinningLottoTicket winningLottoTicket) {
        return winningLottoTicket.getNumbers()
                .stream()
                .filter(winningLottoNumber -> numbers.contains(winningLottoNumber))
                .count();
    }

    private boolean isMatchLottoBonusNumber(WinningLottoTicket winningLottoTicket) {
        return numbers.contains(winningLottoTicket.getBonusLottoNumber());
    }
}
