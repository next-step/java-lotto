package lotto.domain;

import java.util.LinkedList;
import java.util.List;

public class LottoNumbers {
    private List<Integer> lottoNumbers = new LinkedList<>();
    private final int NONE = 0;
    private final int PLUS = 1;

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
            return PLUS;
        }
        return NONE;
    }

    private int getWinning(int containCount) {
        LottoPrize lottoPrize = LottoPrize.findLottoPrizeOfCount(containCount);
        return lottoPrize.getPrize();
    }
}
