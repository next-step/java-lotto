package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

import lotto.common.LottoValidator;

public class LottoTicket {

    private final List<LottoNumber> lottoNumbers;

    public LottoTicket(List<Integer> numbers) {
        LottoValidator.validateLottoNumber(numbers);
        this.lottoNumbers = numbers.stream()
            .map(LottoNumber::new)
            .collect(Collectors.toList());
    }

    public List<LottoNumber> getLottoNumbers() {
        return lottoNumbers;
    }

    @Override
    public String toString() {
        return lottoNumbers.stream()
            .map(lottoNumber -> Integer.toString(lottoNumber.getNumber()))
            .collect(Collectors.joining(", "));
    }
}