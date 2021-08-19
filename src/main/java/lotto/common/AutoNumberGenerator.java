package lotto.common;

import lotto.domain.LottoNumber;

import java.util.*;

public class AutoNumberGenerator implements NumberGenerator {
    private static final Random RANDOM = new Random();
    private static final int LOTTO_NUMBERS_COUNT = 6;
    private static final int MAX_LOTTO_NUMBER = 45;

    private List<LottoNumber> randomNumbers;

    @Override
    public List<LottoNumber> generateNumber() {
        randomNumbers = new ArrayList<>();
        while (randomNumbers.size() < LOTTO_NUMBERS_COUNT) {
            LottoNumber lottoNumber = new LottoNumber(generateLottoNumber());
            if (!validDuplicate(lottoNumber)) {
                randomNumbers.add(lottoNumber);
            }
        }
        sortNumbers();
        return randomNumbers;
    }

    private int generateLottoNumber() {
        return RANDOM.nextInt(MAX_LOTTO_NUMBER) + 1;
    }

    private boolean validDuplicate(LottoNumber lottoNumber) {
        return randomNumbers.contains(lottoNumber);
    }

    private void sortNumbers() {
        randomNumbers.sort(LottoNumber::compareTo);
    }
}
