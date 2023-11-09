package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {

    private List<LottoNumber> lottoNumbers;

    public Lotto() {
        lottoNumbers = new ArrayList<>();
    }

    public Lotto(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = sortLotto(lottoNumbers);
    }

    private List<LottoNumber> sortLotto(List<LottoNumber> lottoNumbers) {
        return lottoNumbers.stream()
                .sorted((o1, o2) -> o1.number() - o2.number()).collect(Collectors.toList());
    }

    public List<LottoNumber> lottoNumbers() {
        return lottoNumbers;
    }
}
