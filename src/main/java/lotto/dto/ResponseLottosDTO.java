package lotto.dto;

import lotto.domain.LottoNumber;

import java.util.List;
import java.util.stream.Collectors;

public class ResponseLottosDTO {
    private final List<LottoNumber> lottoNumbers;

    public ResponseLottosDTO(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers.stream()
                .map(LottoNumber::getLottoNumber)
                .collect(Collectors.toList());
    }
}
