package lotto.domain;

import java.util.List;

public class CustomLottoTicket extends LottoTicket{

    public CustomLottoTicket(List<Integer> lottoNumbers) {
        super(lottoNumbers);
    }

    @Override
    protected List<Integer> createLottoNumber(List<Integer> lottoNumbers) {
        return lottoNumbers;
    }
}
