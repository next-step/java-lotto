package lotto.utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;

public class Converter {

    public static Lotto inputToLotto(String[] numbers) {
        List<LottoNumber> lottoNumbers = Arrays.stream(numbers)
            .map(String::trim)
            .map(LottoNumber::from)
            .collect(Collectors.toList());
        return Lotto.of(lottoNumbers);
    }

    public static String LottoToString(Lotto lotto) {
        List<LottoNumber> lottoNumbers = lotto.getLottoNumbers();
        List<Integer> numbers = lottoNumbers.stream()
            .map(LottoNumber::get)
            .sorted()
            .collect(Collectors.toList());
        return numbers.toString();
    }
}
