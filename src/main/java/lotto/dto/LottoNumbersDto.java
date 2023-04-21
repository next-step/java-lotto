package lotto.dto;

import java.util.ArrayList;
import java.util.List;

public class LottoNumbersDto {
    private final List<List<Integer>> lottoNumbers = new ArrayList<>();

    public void setLottoNumber(List<Integer> lottoNumber) {
        this.lottoNumbers.add(lottoNumber);
    }

    public List<List<Integer>> getLottoNumbers() {
        return this.lottoNumbers;
    }
}
