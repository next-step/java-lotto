package study.step2;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomLottoNumberGenerator implements LottoNumberGenerator {
    private final static int FIRST_SELECTABLE_NUMBER = 1;
    private final static int LIMITED_NUMBER = 45;
    private final static int INCREASE_NUMBER = 1;

    private List<Integer> numbers;

    public RandomLottoNumberGenerator() {
        initLottoNumbers();
    }

    private void initLottoNumbers() {
        List<Integer> initNumbers = IntStream.iterate(FIRST_SELECTABLE_NUMBER, i -> i + INCREASE_NUMBER)
                .limit(LIMITED_NUMBER)
                .boxed()
                .collect(Collectors.toList());

        this.numbers = initNumbers;
    }

    @Override
    public List<Integer> getLottoNumbers() {
        Collections.shuffle(numbers);
        List<Integer> selectedNumbers = numbers.stream()
                                               .limit(6)
                                               .collect(Collectors.toList());
        Collections.sort(selectedNumbers);
        return selectedNumbers;
    }
}
