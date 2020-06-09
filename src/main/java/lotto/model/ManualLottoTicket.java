package lotto.model;

import java.util.List;

public class ManualLottoTicket extends LottoTicket {

    private ManualLottoTicket(final List<LottoNumber> lottoNumbers) {
        super(lottoNumbers);
    }

    public static ManualLottoTicket create(final List<LottoNumber>  lottoNumbers) {
        return new ManualLottoTicket(lottoNumbers);
    }
}

