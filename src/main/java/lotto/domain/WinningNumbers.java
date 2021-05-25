package lotto.domain;

import lotto.exception.CustomIllegalArgumentException;

import java.util.HashSet;
import java.util.TreeSet;

public class WinningNumbers {

    private final int NUMBER_COUNT = 6;

    private final TreeSet<LottoNumber> winningNumbers;
    private LottoNumber bonusNumber;
    
    public WinningNumbers(int[] winningNumbersArray, int bonusNumberInt) throws CustomIllegalArgumentException {
        checkNotNullOrEmpty(winningNumbersArray);
        checkNumberCount(winningNumbersArray);
        checkDuplicate(winningNumbersArray);
        winningNumbers = saveWinningNumbers(winningNumbersArray);
        bonusNumber = saveBonusNumber(bonusNumberInt);
    }

    private TreeSet<LottoNumber> saveWinningNumbers(int[] input) {
        TreeSet<LottoNumber> inputs = new TreeSet<>();
        for (int n : input) {
            inputs.add(new LottoNumber(n));
        }
        return inputs;
    }

    private void checkNumberCount(int[] input) throws CustomIllegalArgumentException {
        if (input.length != NUMBER_COUNT) {
            throw new CustomIllegalArgumentException(Message.ERROR_LOTTO_NUMBER_WRONG_COUNT, NUMBER_COUNT);
        }
    }

    private void checkNotNullOrEmpty(int[] input) throws CustomIllegalArgumentException {
        if (input == null || input.length == 0) {
            throw new CustomIllegalArgumentException(Message.ERROR_EMPTY_INPUT);
        }
    }

    private void checkDuplicate(int[] input) throws CustomIllegalArgumentException {
        HashSet<LottoNumber> inputs = new HashSet<>();
        for (int n : input) {
            inputs.add(new LottoNumber(n));
        }
        if (inputs.size() < NUMBER_COUNT) {
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
