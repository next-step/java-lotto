package view;

import domain.LottoNumber;

import java.util.List;

public class LottoView {
    List<LottoNumber> lottoNumbers;

    public LottoView(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public List<LottoNumber> getLottoNumbers() {
        return lottoNumbers;
    }
}
