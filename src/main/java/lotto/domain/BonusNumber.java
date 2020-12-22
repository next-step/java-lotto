package lotto.domain;

import lotto.util.NumberUtil;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

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
        int bonusNumber = NumberUtil.convertStringToInteger(newbonusNumber);
        List<Integer> lastWinningNumbers = NumberUtil.convertStringToIntegerList(lastWinningNumber);
        Optional<Integer> anyMatchNumber = lastWinningNumbers.stream()
                .filter((number) -> number == bonusNumber).findAny();
        if( anyMatchNumber.isPresent()) {
            throw new RuntimeException(NUMBER_EXIST_EXCEPTION);
        }
        return bonusNumber;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o instanceof BonusNumber) {
            BonusNumber that = (BonusNumber) o;
            return newbonusNumber == that.newbonusNumber;
        };
        if(o instanceof Integer) {
            return this.newbonusNumber == ((Integer) o).intValue();
        }
        return false;
    }


}

