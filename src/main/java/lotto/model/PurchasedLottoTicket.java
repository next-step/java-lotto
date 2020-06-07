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
}
