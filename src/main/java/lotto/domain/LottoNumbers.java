package lotto.domain;

import lotto.Utils;

import java.util.*;

public class LottoNumbers {
    private static final int LOTTO_NUMBER_SIZE = 6;
    public static final int MATCH_COUNT_INIT = 0;

    private final Set<LottoNumber> lottoNumbers;

    public LottoNumbers(Integer[] lottoNumbers) {
        Set<LottoNumber> inputNumbers = new HashSet<>();
        for(Integer number : lottoNumbers) {
            inputNumbers.add(new LottoNumber(number));
        }
        this.lottoNumbers = inputNumbers;
        checkNumberSize(inputNumbers);
    }

    private void checkNumberSize(Set<LottoNumber> lottoNumbers) {
        if(lottoNumbers.size() < LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException();
        }
    }

    public int size() {
        return lottoNumbers.size();
    }

    int matchCount(LottoNumbers luckyNumbers) {
        int matchCount = MATCH_COUNT_INIT;
        for (LottoNumber number : lottoNumbers) {
            matchCount += luckyNumbers.contains(number);
        }

        return matchCount;
    }

    int contains(LottoNumber lottoNumber) {
        int result = 0;
        for(LottoNumber number : lottoNumbers) {
            result += number.compareNumber(lottoNumber);
        }
        return result;
    }

    @Override
    public String toString() {
        return Utils.printLottoNumbers(lottoNumbers);
    }
}
