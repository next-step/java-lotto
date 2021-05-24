package lotto.domain;

import lotto.exception.CustomIllegalArgumentException;

import java.util.HashSet;
import java.util.TreeSet;

public class WinningNumbers {

    private final int NUMBER_COUNT = 6;

    private final TreeSet<LottoNumber> numbers;
    private BonusNumber bonusNumber;

    public WinningNumbers(int[] input) throws CustomIllegalArgumentException {
        checkNotNullOrEmpty(input);
        checkNumberCount(input);
        checkDuplicate(input);
        numbers = saveWinningNumbers(input);
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
        return numbers.contains(number);
    }

    public BonusNumber bonusNumber() {
        return this.bonusNumber;
    }

    public void addBonusNumber(int number) {
        BonusNumber bonusNumber = new BonusNumber(number);
        if (numbers.contains(bonusNumber)) {
            throw new CustomIllegalArgumentException(Message.ERROR_BONUS_NUMBER_DUPLICATED);
        }
        this.bonusNumber = bonusNumber;
    }
}
