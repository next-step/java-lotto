package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

import static lotto.controller.LottoMachine.LOTTO_NUMBER_COUNT;

public class Lotto {

    private final List<LottoNumber> lottoNumbers;

    public Lotto(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
        validateLotto();
    }

    private void validateLotto() {
        if (lottoNumbers.size() > LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException("로또 번호 갯수는 6개 이하입니다");
        }
    }

    public int numberOfSize() {
        return lottoNumbers.size();
    }

    public String numbers() {
        return lottoNumbers.stream()
                .map(LottoNumber::parseString)
                .collect(Collectors.joining(","));
    }

    public boolean hasValue(LottoNumber lottoNumber) {
        return lottoNumbers.contains(lottoNumber);
    }
}
