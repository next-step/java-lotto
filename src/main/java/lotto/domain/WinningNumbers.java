package lotto.domain;

import lotto.exception.CustomIllegalArgumentException;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.TreeSet;

public class WinningNumbers {

    private final int NUMBER_COUNT = 6;

    private final TreeSet<LottoNumber> winningNumbers;
    private LottoNumber bonusNumber;

    public WinningNumbers(List<Integer> numbers, int number) throws CustomIllegalArgumentException {
        checkNotNullOrEmpty(numbers);
        checkNumberCount(numbers);
        checkDuplicate(numbers);
        winningNumbers = saveWinningNumbers(numbers);
        bonusNumber = saveBonusNumber(number);
    }

    private TreeSet<LottoNumber> saveWinningNumbers(List<Integer> input) {
        TreeSet<LottoNumber> inputs = new TreeSet<>();
        for (int n : input) {
            inputs.add(new LottoNumber(n));
        }
        return inputs;
    }

    private void checkNumberCount(List<Integer> input) throws CustomIllegalArgumentException {
        if (input.size() != NUMBER_COUNT) {
            throw new CustomIllegalArgumentException(Message.ERROR_LOTTO_NUMBER_WRONG_COUNT, NUMBER_COUNT);
        }
    }

    private void checkNotNullOrEmpty(List<Integer> input) throws CustomIllegalArgumentException {
        if (input == null || input.size() == 0) {
            throw new CustomIllegalArgumentException(Message.ERROR_EMPTY_INPUT);
        }
    }

    private void checkDuplicate(List<Integer> input) throws CustomIllegalArgumentException {
        HashSet<Integer> setForDuplicateCheck = new HashSet<>(input);
        if (setForDuplicateCheck.size() < NUMBER_COUNT) {
            throw new CustomIllegalArgumentException(Message.ERROR_LOTTO_NUMBER_DUPLICATED, NUMBER_COUNT);
        }
    }

    public boolean contains(LottoNumber number) {
        return winningNumbers.contains(number);
    }

    public LottoNumber bonusNumber() {
        return this.bonusNumber;
    }

    private LottoNumber saveBonusNumber(int number) throws CustomIllegalArgumentException {
        LottoNumber bonusNumber = new LottoNumber(number);
        if (winningNumbers.contains(bonusNumber)) {
            throw new CustomIllegalArgumentException(Message.ERROR_BONUS_NUMBER_DUPLICATED);
        }
        return bonusNumber;
    }
}
