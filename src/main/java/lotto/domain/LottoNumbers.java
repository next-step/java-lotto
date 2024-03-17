package lotto.domain;

import lotto.Exception.ReachedMaxIndexException;
import lotto.data.LottoNumbersVO;

import java.util.List;

import static lotto.util.ConstUtils.*;

public class LottoNumbers {

    private final LottoNumbersVO lottoNumbers;
    private int currentIndex = 0;

    public LottoNumbers() {
        lottoNumbers = new LottoNumbersVO();
    }

    public LottoNumbers(List<Integer> manualNumbers) {
        this.lottoNumbers = new LottoNumbersVO(manualNumbers);
    }

    public int nextNumber() {
        if (isOutOfIndexOfLottoNumbers()) {
            throw new ReachedMaxIndexException();
        }
        return lottoNumbers.positionValue(this.currentIndex++);
    }

    public List<Integer> getPurchasedLottoNumber() {
        return this.lottoNumbers.getLottoNumbers();
    }

    public int countMatchedWinningNumbers(LottoNumbers winningNumbers) {
        winningNumbers.scanReset();
        int matchCount = 0;

        for (int i = 0; i < LOTTO_NUMBER_COUNT; i++) {
            int winningNumber = winningNumbers.nextNumber();
            matchCount += matchesLottoNumber(winningNumber);
        }

        return matchCount;
    }

    public void scanReset() {
        this.currentIndex = 0;
    }

    @Override
    public String toString() {
        return this.lottoNumbers.toString();
    }

    private boolean isOutOfIndexOfLottoNumbers() {
        return currentIndex == LOTTO_NUMBER_COUNT;
    }

    private int matchesLottoNumber(int winningNumber) {
        if (this.lottoNumbers.isContain(winningNumber)) {
            return MATCHED_COUNT;
        }

        return NOT_MATCHED_COUNT;
    }
}
