package lotto.controller.dto;

import java.util.List;

public class LottoNumbersDto {

    private final List<Integer> lottoNumbers;

    public LottoNumbersDto(List<Integer> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers;
    }
}
