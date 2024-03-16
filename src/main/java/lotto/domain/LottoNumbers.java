package lotto.domain;

import lotto.Exception.ReachedMaxIndexException;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

public class LottoNumbers {

    public static final int MAXIMUM_LOTTO_RANGE = 46;
    public static final int MINIMUM_LOTTO_RANGE = 0;
    private final List<Integer> lottoNumbers;
    private int currentIndex = 0;

    public LottoNumbers(List<Integer> manualNumbers) {
        manualNumbers.forEach(this::validateLottoNumberRange);

        this.lottoNumbers = manualNumbers;
    }

    public LottoNumbers() {
        lottoNumbers = new ArrayList<>();

        Random random = new Random();
        for (int i = 0; i < 6; i++) {
            lottoNumbers.add(random.nextInt(MAXIMUM_LOTTO_RANGE));
        }
    }

    public Stream<Integer> stream() {
        return lottoNumbers.stream();
    }

    public int nextNumber() {
        if (isOutOfIndexOfLottoNumbers()) {
            throw new ReachedMaxIndexException();
        }
        return lottoNumbers.get(currentIndex++);
    }

    private boolean isOutOfIndexOfLottoNumbers() {
        return currentIndex == lottoNumbers.size();
    }

    public int countMatchedWinningNumbers(LottoNumbers winningNumbers) {
        int matchCount = 0;

        for (int i = 0; i < 6; i++) {
            int winningNumber = winningNumbers.nextNumber();
            if (lottoNumbers.contains(winningNumber)) {
                matchCount++;
            }
        }

        return matchCount;
    }

    private void validateLottoNumberRange(int number) {
        if (number <= MINIMUM_LOTTO_RANGE || number >= MAXIMUM_LOTTO_RANGE) {
            throw new IllegalArgumentException("유효한 로또 번호가 아닙니다. 1~45 숫자중 입력 해 주세요.");
        }
    }
}
