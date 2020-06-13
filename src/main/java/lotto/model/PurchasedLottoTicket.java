package lotto.model;

import java.util.List;
import lotto.utils.AutomaticLottoGenerator;

public class PurchasedLottoTicket extends LottoTicket {

    private PurchasedLottoTicket(List<LottoNumber> lottoNumbers) {
        super(lottoNumbers);
    }

    public static PurchasedLottoTicket create() {
        return new PurchasedLottoTicket(AutomaticLottoGenerator.createLottoNumbers());
    }

    public static PurchasedLottoTicket create(List<LottoNumber>  lottoNumbers) {
        return new PurchasedLottoTicket(lottoNumbers);
    }
}
