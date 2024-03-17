package lotto.domain;

import lotto.Exception.ReachedMaxIndexException;
import lotto.util.ConstUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

public class LottoNumbers {

    private final List<Integer> lottoNumbers;
    private int currentIndex = 0;

    public LottoNumbers() {
        this.lottoNumbers = new ArrayList<>();

        Random random = new Random();
        for (int i = 0; i < 6; i++) {
            lottoNumbers.add(selectLottoNumber(random));
        }
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

        for (int i = 0; i < 6; i++) {
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

    private int selectLottoNumber(Random random) {
        return random.nextInt(ConstUtils.MAXIMUM_LOTTO_RANGE) + 1;
    }

    private void validateLottoNumberRange(int number) {
        if (number < ConstUtils.MINIMUM_LOTTO_RANGE || number > ConstUtils.MAXIMUM_LOTTO_RANGE) {
            throw new IllegalArgumentException("유효한 로또 번호가 아닙니다. 1~45 숫자중 입력 해 주세요.");
        }
    }

    private boolean isOutOfIndexOfLottoNumbers() {
        return currentIndex == this.lottoNumbers.size();
    }

    private int matchesLottoNumber(int winningNumber) {
        if (this.lottoNumbers.contains(winningNumber)) {
            return ConstUtils.MATCHED_COUNT;
        }

        return ConstUtils.NOT_MATCHED_COUNT;
    }
}
