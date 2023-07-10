package lotto;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {

    private List<LottoNumber> lottoNumbers;

    public Lotto(List<Integer> lottoNumbers) {
        this.lottoNumbers = lottoNumbers.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList());
    }
}
