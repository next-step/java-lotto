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

    public LottoNumbers(Set<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
        checkNumberSize(lottoNumbers);
    }

    private void checkNumberSize(Set<LottoNumber> lottoNumbers) {
        if(lottoNumbers.size() != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException("번호의 갯수가 맞지 않습니다.");
        }
    }

    public int size() {
        return lottoNumbers.size();
    }

    int matchCount(LottoNumbers luckyNumbers) {
        int matchCount = MATCH_COUNT_INIT;
        for (LottoNumber number : lottoNumbers) {
            matchCount += luckyNumbers.compare(number);
        }

        return matchCount;
    }

    public int compare(LottoNumber lottoNumber) {
        return (int) lottoNumbers.stream()
                .filter(number -> number.compareNumber(lottoNumber) > 0)
                .count();
    }

    boolean isMatchBonus(WinningLottoNumbers winningLottoNumbers) {
        int result = winningLottoNumbers.compareBonus(lottoNumbers);
        return (result == MATCH_COUNT_ONE);
    }

    @Override
    public String toString() {
        return Utils.printLottoNumbers(lottoNumbers);
    }
}
