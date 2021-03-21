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
        return 0;
    }

    public String numbers() {
        return lottoNumbers.stream()
                .map(LottoNumber::of)
                .collect(Collectors.joining(","));
    }

    public int howMatch(Lotto winingLotto) {
        return (int) winingLotto.of()
                .stream()
                .filter(this::isIn)
                .count();
    }

    private boolean isIn(LottoNumber lottoNumber) {
        return lottoNumbers.contains(lottoNumber);
    }

    private List<LottoNumber> of() {
        return lottoNumbers;
    }
}
