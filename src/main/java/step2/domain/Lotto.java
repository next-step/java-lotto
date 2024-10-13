package step2.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private final List<LottoNumber> lottoNumbers;

    public Lotto(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    // 로또 번호 리스트 반환
    public List<LottoNumber> getLottoNumbers() {
        return lottoNumbers;
    }

    @Override
    public String toString() {
        return "[" + lottoNumbers.stream()
                .map(lottoNumber -> String.valueOf(lottoNumber.getLottoNumber()))
                .collect(Collectors.joining(", ")) + "]";
    }
}
