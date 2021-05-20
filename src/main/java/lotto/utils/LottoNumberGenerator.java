package lotto.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumberGenerator {

    public static List<Integer> manualGenerator(List<String> numbers) {
        List<Integer> lottoNumbers = transStringNumbersToIntegerNumbers(numbers);

        Collections.sort(lottoNumbers);

        return Collections.unmodifiableList(lottoNumbers);
    }

    private static List<Integer> transStringNumbersToIntegerNumbers(List<String> numbers) {
        List<Integer> lottoNumbers = new ArrayList<>();

        for (String number : numbers) {
            lottoNumbers.add(Integer.valueOf(number));
        }

        return lottoNumbers;
    }

    public static List<Integer> autoGenerator() {
        List<Integer> lottoNumbers = randomSixLottoNumbers();

        Collections.sort(lottoNumbers);

        return Collections.unmodifiableList(lottoNumbers);
    }

    private static List<Integer> randomSixLottoNumbers() {
        List<Integer> availableLottoNumbers = availableAllLottoNumbers();
        Collections.shuffle(availableLottoNumbers);

        return availableLottoNumbers.subList(0, 6);
    }

    private static List<Integer> availableAllLottoNumbers() {
        return IntStream.range(1, 45)
                .mapToObj(i->i).collect(Collectors.toList());
    }
}
