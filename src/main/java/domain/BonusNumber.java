package domain;

import exception.NotValidInputException;

public class BonusNumber {

    private final Integer bonusNumber;

    public BonusNumber(String number) {
        int bonusNumber = Integer.parseInt(number);
        inputValidation(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public static BonusNumber from(String input) {
        return new BonusNumber(input);
    }

    private void inputValidation(int input) {
        if (input <= 0) {
            throw new NotValidInputException("양의 숫자만 입력하세요");
        }
    }

    public Integer getBonusNumber() {
        return bonusNumber;
    }

}
