package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoNumberGenerator {
    public static final int START_NUMBER = 1;
    public static final int END_NUMBER = 45;
    private static List<Integer> lottoNumbers = new ArrayList<>();

    public static List<Integer> createLottoNumber() {
        List<Integer> numbers = new ArrayList<>();

        for (int i = START_NUMBER; i <= END_NUMBER; i++) {
            numbers.add(i);
        }
        Collections.shuffle(numbers);

        return lottoNumbers = numbers.stream()
                .limit(6)
                .collect(Collectors.toList());
    }

    public static List<Integer> createLottoNumber(List<Integer> numbers) {
        numbers.stream()
                .forEach(number -> lottoNumbers.add(number));
        Collections.sort(lottoNumbers);
        return lottoNumbers;
    }
}
