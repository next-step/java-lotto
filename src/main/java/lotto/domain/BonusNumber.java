package lotto.domain;

import lotto.util.NumberUtil;

import java.util.List;;
import java.util.function.Predicate;

public class BonusNumber {

    private int newbonusNumber;

    private static final String NUMBER_EXIST_EXCEPTION = "Bonus Number exist in lastWinningNumber.";

    protected BonusNumber(int bonusNumber){
        this.newbonusNumber = bonusNumber;
    }

    public BonusNumber(String lastWinningNumber, String newbonusNumber) {
        this.newbonusNumber = validBonusNumber(lastWinningNumber, newbonusNumber);
    }

    protected int validBonusNumber(String lastWinningNumber, String newbonusNumber){
        int inputBonusNumber = NumberUtil.convertStringToInteger(newbonusNumber);
        BonusNumber bonusNumber = new BonusNumber(inputBonusNumber);
        List<Integer> lastWinningNumbers = NumberUtil.convertStringToIntegerList(lastWinningNumber);
        Predicate<Integer> existBonusNumber = (number) -> bonusNumber.equals(number);
        boolean duplicateBonusNumber = lastWinningNumbers.stream().anyMatch(existBonusNumber);
        if(duplicateBonusNumber == true){
            throw new IllegalArgumentException(NUMBER_EXIST_EXCEPTION);
        }
        return inputBonusNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o instanceof BonusNumber) {
            BonusNumber that = (BonusNumber) o;
            return newbonusNumber == that.newbonusNumber;
        };
        if(o instanceof Integer) {
            boolean integerIsEqual = this.newbonusNumber == ((Integer) o).intValue();
            return integerIsEqual;
        }
        return false;
    }
    public boolean notEquals(Object o) {
        if (this == o) return false;
        if (o instanceof BonusNumber) {
            BonusNumber that = (BonusNumber) o;
            return newbonusNumber != that.newbonusNumber;
        };
        if(o instanceof Integer) {
            boolean integerIsEqual = this.newbonusNumber != ((Integer) o).intValue();
            return integerIsEqual;
        }
        return true;
    }

}

