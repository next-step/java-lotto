package lottogame.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LottoAutoStrategy implements LottoStrategy {
    private final Random RANDOM = new Random();

    @Override
    public LottoNumbers generateLottoNumbers() {
        List<LottoNumber> numbers = new ArrayList<>();

        while (numbers.size() < LottoGameConstants.LOTTO_NUMBER_COUNT) {
            int randomNumber = RANDOM.nextInt(LottoGameConstants.MAX_LOTTO_NUMBER) + 1;
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

