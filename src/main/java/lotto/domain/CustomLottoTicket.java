package lotto.domain;

import java.util.List;

public class CustomLottoTicket extends LottoTicket{

    public CustomLottoTicket(List<LottoNumber> lottoNumbers) {
        super(lottoNumbers);
    }

    @Override
    protected List<LottoNumber> create(List<LottoNumber> lottoNumbers) {
        return lottoNumbers;
    }

}
