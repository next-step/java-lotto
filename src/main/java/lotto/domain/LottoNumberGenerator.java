package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumberGenerator {

    public static List<LottoNumber> generateLottoNumbers() {
        List<Integer> validNumbers = getValidNumbers();
        List<Integer> lottoNumbers = selectRandomNumbers(validNumbers);

        return lottoNumbers.stream()
            .map(LottoNumber::new)
            .collect(Collectors.toList());
    }

    private static List<Integer> getValidNumbers() {
        return IntStream.range(LottoNumber.MIN_LOTTO_NUMBER, LottoNumber.MAX_LOTTO_NUMBER + 1)
            .boxed()
            .collect(Collectors.toList());
    }

    private static List<Integer> selectRandomNumbers(List<Integer> numbers) {
        Collections.shuffle(numbers);
        List<Integer> selectedNumbers = numbers.subList(0, 6);
        Collections.sort(selectedNumbers);
        return selectedNumbers;
    }
}
