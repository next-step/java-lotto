package lotto.domain;

import lotto.Exception.ReachedMaxIndexException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static lotto.util.ConstUtils.*;

public class LottoNumbers {

    private final List<Integer> lottoNumbers;
    private int currentIndex = 0;

    public LottoNumbers() {
        List<Integer> lottoBalls = createLottoBalls();
        Collections.shuffle(lottoBalls);

        lottoNumbers = lottoBalls.subList(0, LOTTO_NUMBER_COUNT);
        Collections.sort(lottoNumbers);
    }

    public LottoNumbers(List<Integer> manualNumbers) {
        manualNumbers.forEach(this::validateLottoNumberRange);

        this.lottoNumbers = manualNumbers;
    }

    public int nextNumber() {
        if (isOutOfIndexOfLottoNumbers()) {
            throw new ReachedMaxIndexException();
        }
        return lottoNumbers.get(this.currentIndex++);
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

    public Stream<Integer> stream() {
        return lottoNumbers.stream();
    }

    public void scanReset() {
        this.currentIndex = 0;
    }

    @Override
    public String toString() {
        return this.lottoNumbers.toString();
    }

    private List<Integer> createLottoBalls() {
        List<Integer> lottoBalls = new ArrayList<>();

        for (int i = MINIMUM_LOTTO_RANGE; i <= MAXIMUM_LOTTO_RANGE; i++) {
            lottoBalls.add(i);
        }
        return lottoBalls;
    }

    private void validateLottoNumberRange(int number) {
        if (number < MINIMUM_LOTTO_RANGE || number > MAXIMUM_LOTTO_RANGE) {
            throw new IllegalArgumentException("유효한 로또 번호가 아닙니다. 1~45 숫자중 입력 해 주세요.");
        }
    }

    private boolean isOutOfIndexOfLottoNumbers() {
        return currentIndex == this.lottoNumbers.size();
    }

    private int matchesLottoNumber(int winningNumber) {
        if (this.lottoNumbers.contains(winningNumber)) {
            return MATCHED_COUNT;
        }

        return NOT_MATCHED_COUNT;
    }
}
