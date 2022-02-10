package lotto.utils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;

public class Converter {

    public static Lotto inputToLotto(String[] numbers) {
        List<LottoNumber> lottoNumbers = Arrays.stream(numbers)
            .map(String::trim)
            .map(Integer::parseInt)
            .map(LottoNumber::new)
            .collect(Collectors.toList());
        return Lotto.of(lottoNumbers);
    }

    public static String LottoToString(Lotto lotto) {
        List<Integer> lottoNumbers = lotto.getNumbers();
        Collections.sort(lottoNumbers);
        return lottoNumbers.toString();
    }
}
