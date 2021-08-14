package lotto.common;

import lotto.domain.LottoNumber;

import java.util.*;

public class AutoNumberGenerator implements NumberGenerator {
    private static final int LOTTO_NUMBERS_COUNT = 6;

    private List<LottoNumber> randomNumbers;

    @Override
    public List<LottoNumber> generateNumber() {
        randomNumbers = new ArrayList<>();
        while (randomNumbers.size() < LOTTO_NUMBERS_COUNT) {
            LottoNumber lottoNumber = new LottoNumber();
            if (validDuplicate(lottoNumber)) {
                randomNumbers.add(lottoNumber);
            }
        }
        sortNumbers();
        return randomNumbers;
    }

    private boolean validDuplicate(LottoNumber lottoNumber) {
        for (LottoNumber number : randomNumbers) {
            if (lottoNumber.getNumber() == number.getNumber()) {
                return false;
            }
        }
        return true;
    }

    private void sortNumbers() {
        randomNumbers.sort(LottoNumber::compareTo);
    }
}
