package lotto.dto;

import java.util.List;

public class ResponseLottosDTO {
    private final List<Integer> lottoNumbers;

    public ResponseLottosDTO(List<Integer> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers;
    }
}
