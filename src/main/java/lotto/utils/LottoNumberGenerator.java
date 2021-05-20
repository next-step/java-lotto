package lotto.utils;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumberGenerator {

    public static List<Integer> randomSixLottoNumbers() {
        List<Integer> availableLottoNumbers = availableAllLottoNumbers();
        Collections.shuffle(availableLottoNumbers);

        return availableLottoNumbers.subList(0, 6);
    }

    private static List<Integer> availableAllLottoNumbers() {
        return IntStream.range(1, 45)
                .mapToObj(i->i).collect(Collectors.toList());
    }
}
