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
}
