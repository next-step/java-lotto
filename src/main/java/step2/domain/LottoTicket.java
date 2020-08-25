package step2.domain;

import java.util.List;


public class LottoTicket {
    List<LottoNumbers> lottoNumbersList;

    public LottoTicket(List<LottoNumbers> lottoNumbersList) {
        this.lottoNumbersList = lottoNumbersList;
    }

    public List<LottoNumbers> getLottoNumbersList() {
        return lottoNumbersList;
    }


}
