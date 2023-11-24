package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Lotto {
    private List<LottoNumber> numbers = new ArrayList<>();
    private final int NUMBERS_MAX_SIZE = 6;

    public Lotto(List<Integer> inputLottoNumbers) {
        for (Integer inputNumber : inputLottoNumbers) {
            checkCanAdd(inputNumber);
            numbers.add(new LottoNumber(inputNumber));
        }
        numbers.sort(Comparator.comparingInt(LottoNumber::getLottoNumber));
    }

    private void checkCanAdd(Integer inputNumber) {
        checkNumberSize();
        checkDuplicateNumber(inputNumber);
    }

    private void checkNumberSize() {
        if (NUMBERS_MAX_SIZE <= numbers.size()) {
            throw new IllegalArgumentException("Lotto`s size status is max, So can not add number.");
        }
    }

    private void checkDuplicateNumber(int inputNumber) {
        for (LottoNumber number : numbers) {
            number.checkDuplicateNumber(new LottoNumber(inputNumber));
        }
    }

    public final List<LottoNumber> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }

    public int countWinningNumber(List<LottoNumber> winningNumbers) {
        Integer countWinning = 0;
        for (LottoNumber lottoNumber : numbers) {
            countWinning = addIfEqualWinningNumber(lottoNumber, winningNumbers, countWinning);
        }
        return countWinning;
    }

    private Integer addIfEqualWinningNumber(
            LottoNumber lottoNumber,
            List<LottoNumber> winningNumbers,
            Integer countWinning) {
        for (LottoNumber winningNumber : winningNumbers) {
            countWinning += getNumberIfEqual(lottoNumber, winningNumber);
        }
        return countWinning;
    }

    private int getNumberIfEqual(LottoNumber lottoNumber, LottoNumber winningNumber) {
        return lottoNumber.getResultIfEqual(winningNumber);
    }

    public boolean hasBonus(LottoNumber bonus) {
        return bonus != null && numbers.stream()
                .anyMatch(e -> e.getResultIfEqual(bonus) == 1);
    }
}
