package step2.model;

import java.util.List;
import step2.utils.AutomaticLottoGenerator;

public class PurchasedLottoTicket extends LottoTicket {

    private PurchasedLottoTicket(final List<LottoNumber> lottoNumbers) {
        super(lottoNumbers);
    }

    public static PurchasedLottoTicket create() {
        return new PurchasedLottoTicket(AutomaticLottoGenerator.createLottoNumbers());
    }

    public LottoResult match(WinningLottoTicket winningLottoTicket) {
        long count = winningLottoTicket.getNumbers()
            .stream()
            .filter(winningLottoNumber -> numbers.contains(winningLottoNumber))
            .count();

        boolean isMatchedLottoBonusNumber = numbers.contains(winningLottoTicket.getBonusLottoNumber());

        return LottoResult.of(LottoMatchCount.of(Math.toIntExact(count), isMatchedLottoBonusNumber));
    }
}
