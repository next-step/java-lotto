package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoNumberGenerator {

    public List<LottoNumber> generator(List<String> numbers) {
        List<LottoNumber> lottoNumbers = transStringNumbersToIntegerNumbers(numbers);

        Collections.sort(lottoNumbers);

        return Collections.unmodifiableList(lottoNumbers);
    }

    private List<LottoNumber> transStringNumbersToIntegerNumbers(List<String> numbers) {
        return numbers.stream()
                .map(number -> Integer.valueOf(number))
                .map(LottoNumber::create)
                .collect(Collectors.toList());
    }

}
