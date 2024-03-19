package lotto.dto;

import lotto.model.LottoNumber;

import java.util.List;
import java.util.stream.Collectors;

public class LottoNumberResponse {
    private List<String> numbers;

    public LottoNumberResponse(List<String> numbers) {
        this.numbers = numbers;
    }

    public static LottoNumberResponse from(List<LottoNumber> lottoNumbers) {
        return new LottoNumberResponse(map(lottoNumbers));
    }

    private static List<String> map(List<LottoNumber> lottoNumbers) {
        return lottoNumbers.stream()
                .map(LottoNumber::toString)
                .collect(Collectors.toList());
    }

    public List<String> getNumbers() {
        return numbers;
    }
}
