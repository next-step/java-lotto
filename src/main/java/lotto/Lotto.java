package lotto;

import java.util.Collections;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class Lotto {
    private static final int LOTTO_NUMBER_COUNT = 6;

    private final List<LottoNumber> numbers;

    Lotto() {
        this.numbers = generateNumbers();
    }

    private List<LottoNumber> generateNumbers() {
        List<LottoNumber> allLottoNumbers = LottoNumber.getAllLottoNumbers();
        Collections.shuffle(allLottoNumbers);

        List<LottoNumber> numbers = allLottoNumbers.stream()
                .limit(LOTTO_NUMBER_COUNT)
                .collect(toList());
        Collections.sort(numbers);

        return numbers;
    }

    List<LottoNumber> getNumbers() {
        return numbers;
    }

    int getNumbersSize() {
        return numbers.size();
    }
}
