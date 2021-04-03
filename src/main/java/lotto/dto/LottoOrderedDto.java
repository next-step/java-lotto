package lotto.dto;

import java.util.List;

public class LottoOrderedDto {
    private final List<Integer> lottoNumbers;

    public LottoOrderedDto(List<Integer> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers;
    }
}
