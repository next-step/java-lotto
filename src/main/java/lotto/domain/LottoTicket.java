package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class LottoTicket {

    private final List<LottoNumber> lottoNumbers;
    private static final int NUMBER_SIZE = 6;

    public LottoTicket (List<Integer> numbers) {
        validate(numbers.size());
        this.lottoNumbers = numbers.stream()
            .map(LottoNumber::new)
            .collect(Collectors.toList());
    }
    private void validate(int size) {
        if (size != NUMBER_SIZE) {
            throw new IllegalArgumentException(String.format("당첨 번호는 %s개 입니다.", NUMBER_SIZE));
        }
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
