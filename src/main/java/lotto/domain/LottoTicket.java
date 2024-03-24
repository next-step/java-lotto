package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class LottoTicket {

    private final List<LottoNumber> lottoNumbers;
    private final int NUMBER_SIZE = 6;

    public LottoTicket (List<Integer> numbers) {
        validate(numbers.size());
        this.lottoNumbers = numbers.stream()
            .map(LottoNumber::new)
            .collect(Collectors.toList());
    }

    public List<LottoNumber> getLottoNumbers() {
        return lottoNumbers;
    }

    private void validate(int size) {
        if (size != NUMBER_SIZE) {
            throw new IllegalArgumentException("당첨 번호는 6개 입니다.");
        }
    }
}
