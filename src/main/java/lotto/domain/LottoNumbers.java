package lotto.domain;

import java.util.LinkedList;
import java.util.List;

public class LottoNumbers {
    private List<Integer> lottoNumbers = new LinkedList<>();
    private final int FOURTH_COUNT = 3;
    private final int FOURTH = 4;
    private final int THIRD_COUNT = 4;
    private final int THIRD = 3;
    private final int SECOND_COUNT = 5;
    private final int SECOND = 2;
    private final int FIRST_COUNT = 6;
    private final int FIRST = 1;
    private final int NONE = 0;

    public LottoNumbers(List<Integer> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers;
    }

    public int checkWinning(List<Integer> compareToLottoNumbers) {
        int containCount = 0;
        for (Integer lottoNumber : lottoNumbers) {
            containCount += addContainWinningNUmber(compareToLottoNumbers, lottoNumber);
        }
        return getWinning(containCount);
    }

    private int addContainWinningNUmber(List<Integer> compareToLottoNumbers, Integer lottoNumber) {
        if (compareToLottoNumbers.contains(lottoNumber)) {
            return 1;
        }
        return 0;
    }

    private int getWinning(int containCount) {
        if (containCount == FIRST_COUNT) {
            return FIRST;
        }
        if (containCount == SECOND_COUNT) {
            return SECOND;
        }
        if (containCount == THIRD_COUNT) {
            return THIRD;
        }
        if (containCount == FOURTH_COUNT) {
            return FOURTH;
        }
        return NONE;
    }
}
