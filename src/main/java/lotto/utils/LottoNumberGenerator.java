package lotto.utils;

import lotto.domain.LottoNumber;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumberGenerator {

    public static List<LottoNumber> manualGenerator(List<String> numbers) {
        List<LottoNumber> lottoNumbers = transStringNumbersToIntegerNumbers(numbers);

        Collections.sort(lottoNumbers);

        return Collections.unmodifiableList(lottoNumbers);
    }

    private static List<LottoNumber> transStringNumbersToIntegerNumbers(List<String> numbers) {
        return numbers.stream()
                .map(number -> Integer.valueOf(number))
                .map(LottoNumber::create)
                .collect(Collectors.toList());
    }

    public static List<LottoNumber> autoGenerator() {
        List<LottoNumber> lottoNumbers = randomSixLottoNumbers();

        Collections.sort(lottoNumbers);

        return Collections.unmodifiableList(lottoNumbers);
    }

    private static List<LottoNumber> randomSixLottoNumbers() {
        List<LottoNumber> availableLottoNumbers = availableAllLottoNumbers();
        Collections.shuffle(availableLottoNumbers);

        return availableLottoNumbers.subList(0, 6);
    }

    private static List<LottoNumber> availableAllLottoNumbers() {
        return IntStream.range(1, 45)
                .mapToObj(LottoNumber::create).collect(Collectors.toList());
    }
}
