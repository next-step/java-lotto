package step2.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LottoAutoStrategy implements LottoStrategy {
    private final int LOTTO_NUMBER_COUNT = 6;
    private final Random RANDOM = new Random();

    @Override
    public LottoNumbers generateLottoNumbers() {
        List<LottoNumber> numbers = new ArrayList<>();

        while (numbers.size() < LOTTO_NUMBER_COUNT) {
            int randomNumber = RANDOM.nextInt(45);
            if (isContains(numbers, randomNumber)) {
                continue;
            }
            numbers.add(new LottoNumber(randomNumber));
        }


        return new LottoNumbers(numbers);
    }

    private boolean isContains(List<LottoNumber> numbers, int randomNumber) {
        return numbers.stream().anyMatch(number -> number.getNumber() == randomNumber);
    }
}
