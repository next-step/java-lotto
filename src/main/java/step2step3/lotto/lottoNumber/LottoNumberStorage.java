package step2step3.lotto.lottoNumber;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static java.util.stream.Collectors.toUnmodifiableList;

public class LottoNumberStorage {

    private final NumbersGenerator numbersGenerator;
    private final Map<Integer, LottoNumber> lottoNumbers = new HashMap<>();

    public LottoNumberStorage(NumbersGenerator numbersGenerator) {
        this.numbersGenerator = numbersGenerator;
    }

    public List<LottoNumber> lottoNumbers() {
        Set<Integer> numbers = numbersGenerator.numbers();

        return numbers.stream()
                .map(this::lottoNumber)
                .sorted()
                .collect(toUnmodifiableList());
    }

    private LottoNumber lottoNumber(int number) {
        if (lottoNumbers.containsKey(number)) {
            return lottoNumbers.get(number);
        }

        LottoNumber lottoNumber = new LottoNumber(number);
        lottoNumbers.put(number, lottoNumber);
        return lottoNumber;
    }

}
