package lotto.dto;

import lotto.domain.LottoNumber;
import lotto.domain.LottoNumbers;

import java.util.ArrayList;
import java.util.List;

public class LottoNumbersDto {

    List<List<Integer>> lottoNumbers;

    public LottoNumbersDto(List<List<Integer>> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public List<List<Integer>> getLottoNumbers() {
        return lottoNumbers;
    }

    public static LottoNumbersDto of(LottoNumbers lottoNumbers) {
        List<LottoNumber> lottoNumberList = lottoNumbers.getLottoNumbers();
        List<List<Integer>> result = new ArrayList<>();
        for (LottoNumber lottoNumber : lottoNumberList) {
            result.add(lottoNumber.getLottoNumber());
        }
        return new LottoNumbersDto(result);
    }
}
