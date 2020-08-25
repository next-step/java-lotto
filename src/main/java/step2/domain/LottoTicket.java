package step2.domain;

import java.util.List;


public class LottoTicket {
    List<LottoNumber> lottoNumberList;

    public LottoTicket(List<LottoNumber> lottoNumberList) {
        this.lottoNumberList = lottoNumberList;
    }

    public List<LottoNumber> getLottoNumberList() {
        return lottoNumberList;
    }


}
