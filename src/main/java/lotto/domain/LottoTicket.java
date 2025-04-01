package lotto.domain;

import lotto.strategy.LottoStrategy;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class LottoTicket {

    private static final int REQUIRED_COUNT = 6;
    private final List<LottoNumber> lottoNumbers;

    public LottoTicket(List<LottoNumber> lottoNumbers) {
        validateLottoNumbers(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers.stream()
                .map(LottoNumber::getNumber)
                .collect(Collectors.toList());
    }
    private void validateLottoNumbers(List<LottoNumber> lottoNumbers) {
        Set<LottoNumber> uniqueNumbers = lottoNumbers.stream().collect(Collectors.toSet());

        if (uniqueNumbers.size() != REQUIRED_COUNT) {
            throw new IllegalArgumentException("로또 번호는 중복되지 않은 6개의 숫자여야 합니다.");
        }
    }

    public static LottoTicket generateLottoNumbers(LottoStrategy lottoStrategy) {
        List<LottoNumber> generatedNumbers = lottoStrategy.generateLottoNumbers();
        return new LottoTicket(generatedNumbers);
    }


    public boolean contains(LottoNumber lottoNumber) {
        return lottoNumbers.contains(lottoNumber);
    }
}
