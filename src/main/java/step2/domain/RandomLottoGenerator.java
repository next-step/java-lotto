package step2.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class RandomLottoGenerator implements LottoGeneratorStrategy {
    private static final int MINIMUM_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;


    private RandomLottoGenerator() {}

    public static RandomLottoGenerator of(){
        return new RandomLottoGenerator();
    }


    public List<Integer> generateLottoNumbers() {
        return generateLottoNumbers(generateRandomNumbers());
    }

    private static List<Integer> generateLottoNumbers(List<Integer> numbers) {
        List<Integer> lottoNumbers = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            lottoNumbers.add(numbers.get(i));
        }
        return lottoNumbers;
    }

    private List<Integer> generateRandomNumbers() {
        List<Integer> numbers = generateNumbers();
        shuffleNumbers(numbers);
        return numbers;
    }

    private List<Integer> generateNumbers() {
        return Stream.iterate(MINIMUM_LOTTO_NUMBER, integer -> integer+1)
                .limit(MAX_LOTTO_NUMBER)
                .collect(toList());
    }

    private void shuffleNumbers(List<Integer> numbers) {
        Collections.shuffle(numbers);
    }

}
