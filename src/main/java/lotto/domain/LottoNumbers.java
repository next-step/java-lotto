package lotto.domain;

import lotto.Utils;

import java.util.Set;

public class LottoNumbers {
    private static final int LOTTO_NUMBER_SIZE = 6;
    private static final int MATCH_COUNT_INIT = 0;
    private static final int MATCH_COUNT_ONE = 1;

    private final Set<LottoNumber> lottoNumbers;

    public LottoNumbers(Integer[] lottoNumbers) {
        Set<LottoNumber> inputNumbers = Utils.arraysToSet(lottoNumbers);
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

    private int contains(LottoNumber lottoNumber) {
        int result = MATCH_COUNT_INIT;
        for(LottoNumber number : lottoNumbers) {
            result += number.compareNumber(lottoNumber);
        }
        return result;
    }

    boolean isMatchBonus(LottoNumber bonusNumber) {
        int result = contains(bonusNumber);
        return (result == MATCH_COUNT_ONE);
    }

    @Override
    public String toString() {
        return Utils.printLottoNumbers(lottoNumbers);
    }
}
