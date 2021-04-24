package step02.dto;

import step02.model.lotto.LottoNumber;

import java.util.List;

public class LottoNumbersDTO {
    private final List<LottoNumber> lottoNumbers;

    public LottoNumbersDTO(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public List<LottoNumber> getLottoNumbers() {
        return lottoNumbers;
    }

    public int getLottoNumberSize() {
        return lottoNumbers.size();
    }
}
