package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class LottoNumbers {
    List<LottoNumber> lottoNumbers;

    private LottoNumbers(List<LottoNumber> lottoNumbers){
        this.lottoNumbers = lottoNumbers;
    }

    public static LottoNumbers of(List<LottoNumber> lottoNumbers) {
        return new LottoNumbers(lottoNumbers);
    }

    public String value() {
        return "[" +lottoNumbers.stream()
                .map(lottoNumber -> lottoNumber.value())
                .collect(Collectors.joining(", ")) + "]";
    }
}
