package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoFactory {

    public static Lotto createLotto(List<Integer> numbers) {
        List <LottoNumber> lottoNumbers = numbers.stream().map(LottoNumber::of).collect(Collectors.toList());
        return Lotto.of(lottoNumbers);
    }


}
