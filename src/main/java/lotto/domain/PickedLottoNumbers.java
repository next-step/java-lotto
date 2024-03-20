package lotto.domain;

import java.util.List;

public class PickedLottoNumbers {
    private List<LottoNumber> lottoNumberList;

    public void save(LottoNumber lottoNumber) {
        lottoNumberList.add(lottoNumber);
    }

}
