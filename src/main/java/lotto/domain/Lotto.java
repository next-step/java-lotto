package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.validate.NumberValidation.checkLottoSize;

public class Lotto {

    private List<LottoNumber> lottoNumbers;

    public Lotto() {
        lottoNumbers = new ArrayList<>();
    }

    public Lotto(List<LottoNumber> lottoNumbers) {
        checkLottoSize(lottoNumbers);
        this.lottoNumbers = sortLotto(lottoNumbers);
    }

    private List<LottoNumber> sortLotto(List<LottoNumber> lottoNumbers) {
        return lottoNumbers.stream()
                .sorted().collect(Collectors.toList());
    }

    public List<LottoNumber> lottoNumbers() {
        return lottoNumbers;
    }

    @Override
    public String toString() {
        return String.format("[%s]", lottoNumbers.stream().map(LottoNumber::toString)
                .collect(Collectors.joining(", ")));
    }
}
