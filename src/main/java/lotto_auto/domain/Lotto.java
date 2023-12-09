package lotto_auto.domain;

import java.util.List;

public class Lotto {
    private List<LottoNumbers> lottoNumbersList;

    public Lotto() {
        RandomNumberGen randomNumberGen = new LottoNumberGen();
        lottoNumbersList = randomNumberGen.getLottoList();
    }

    public List<LottoNumbers> getLottoNumberList() {
        return lottoNumbersList;
    }
}
