package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class StringLottoNumbers {

    private static final String REGEX = ", ";

    public static Lotto toLotto(String stringLottoNumbers) {
        List<String> lottoNumberList = List.of(stringLottoNumbers.split(REGEX));
        List<LottoNumber> lottoNumbers = lottoNumberList.stream()
                .map(LottoNumber::from)
                .collect(Collectors.toList());
        return Lotto.from(lottoNumbers);
    }

}
