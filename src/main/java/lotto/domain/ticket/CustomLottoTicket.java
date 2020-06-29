package lotto.domain.ticket;

import lotto.domain.store.LottoNumber;

import java.util.List;

public class CustomLottoTicket extends LottoTicket {

    public CustomLottoTicket(List<LottoNumber> lottoNumbers) {
        super(lottoNumbers);
    }

    @Override
    protected List<LottoNumber> create(List<LottoNumber> lottoNumbers) {
        return lottoNumbers;
    }

}
