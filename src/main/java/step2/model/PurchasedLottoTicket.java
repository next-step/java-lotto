package step2.model;

import java.util.List;
import step2.utils.AutomaticLottoGenerator;

public class PurchasedLottoTicket extends LottoTicket {

    private PurchasedLottoTicket(final List<LottoNumber> lottoNumbers) {
        super(lottoNumbers);
    }

    public static PurchasedLottoTicket newInstance() {
        return new PurchasedLottoTicket(AutomaticLottoGenerator.createLottoNumbers());
    }

    public LottoResult match(LottoTicket lottoTicket) {
        long count = lottoTicket.getNumbers()
            .stream()
            .filter(winningLottoNumber -> numbers.contains(winningLottoNumber))
            .count();

        return LottoResult.of(Math.toIntExact(count));
    }
}
