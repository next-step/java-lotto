package step2.domain;

import java.util.List;


public class Lotto {
    List<LottoNumber> lottoList;

    public Lotto(List<LottoNumber> lottoNumberList) {
        lottoList = lottoNumberList;
    }

    public List<LottoNumber> getLottoList() {
        return lottoList;
    }


}
