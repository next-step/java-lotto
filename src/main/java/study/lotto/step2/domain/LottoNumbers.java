package study.lotto.step2.domain;

import java.util.Set;
import java.util.stream.Collectors;

public class LottoNumbers {
    private static final int NUMBER_OF_SELECT = 6;
    private final Set<LottoNumber> lottoNumbers;

    public LottoNumbers(Set<LottoNumber> lottoNumbers) {
        validateLottoNumbers(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    public Set<Integer> numbers() {
        return lottoNumbers.stream()
                .map(LottoNumber::number)
                .collect(Collectors.toUnmodifiableSet());
    }

    private void validateLottoNumbers(Set<LottoNumber> lottoNumbers) {
        if(lottoNumbers.size() != NUMBER_OF_SELECT) {
            throw new IllegalArgumentException("로또 번호 선택 갯수는 " + NUMBER_OF_SELECT + "개입니다: " + lottoNumbers.size());
        }
    }
}
