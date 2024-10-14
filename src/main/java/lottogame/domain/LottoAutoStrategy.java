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
            addUniqueRandomNumber(numbers);
        }
        return new LottoNumbers(numbers);
    }

    private void addUniqueRandomNumber(List<LottoNumber> numbers) {
        int randomNumber = generateRandomNumber();
        if (!isContains(numbers, randomNumber)) {
            numbers.add(new LottoNumber(randomNumber));
        }
    }

    private int generateRandomNumber() {
        return RANDOM.nextInt(LottoGameConstants.MAX_LOTTO_NUMBER) + 1;
    }

    private boolean isContains(List<LottoNumber> numbers, int randomNumber) {
        return numbers.stream().anyMatch(number -> number.getNumber() == randomNumber);
    }
}

