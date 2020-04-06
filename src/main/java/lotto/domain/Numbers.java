package lotto.domain;

import lotto.exception.NotANumberException;
import lotto.exception.NumberDuplicateException;
import lotto.exception.OutOfRangeException;

import java.util.*;
import java.util.stream.Collectors;

public class Numbers {
    public static final int TICKET_MIN_NUMBER = 1;
    public static final int TICKET_MAX_NUMBER = 45;
    public static final int NUMBER_LIMIT_COUNT = 6;

    private final Set<Integer> numbers;
    private int bonusNumber;


    public Numbers(List<Integer> inputNumber) {
        checkLengthValidation(inputNumber);
        this.numbers = new HashSet<>(inputNumber);
        checkNumberValidation(numbers);
        checkDuplicate(numbers);
    }

    public Set<Integer> showNumbers() {
        return numbers.stream()
                .sorted()
                .collect(Collectors.toCollection(LinkedHashSet::new));
    }
    public void addBonusNumber(int bonusNumber) {
        checkNumberRange(bonusNumber);
        bonusNumberValidator(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public int getBonusNumber(){
        return bonusNumber;
    }

    public boolean hasBonusNumber(int bonusNumber){
        return numbers.contains(bonusNumber);
    }

    private void checkLengthValidation(List<Integer> numberInformation) {
        if (numberInformation.size() != NUMBER_LIMIT_COUNT) {
            throw new OutOfRangeException();
        }
    }

    private Set<Integer> checkNumberValidation(Set<Integer> numbers) {
        for (int number : numbers) {
            checkNumberRange(number);
        }
        return numbers;
    }

    private void checkDuplicate(Set<Integer> inputNumber) {
        if (inputNumber.size() < NUMBER_LIMIT_COUNT) {
            throw new NumberDuplicateException();
        }
    }

    private void checkNumberRange(int number) {
        if (number < TICKET_MIN_NUMBER || number > TICKET_MAX_NUMBER) {
            throw new NotANumberException(number);
        }
    }
    private void bonusNumberValidator(int bonusNumber) {
        if(numbers.contains(bonusNumber)){
            throw new NumberDuplicateException();
        }
    }
}
