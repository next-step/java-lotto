package autolotto.model;

import autolotto.exception.IsNotScopeInTheNumber;
import autolotto.exception.IsNotSixNumberException;

public class WinningNumbers {

    private final String numbers;

    public WinningNumbers(String stringNumbers) throws NumberFormatException {

        numbers = stringNumbers;
        String[] splitNumbers = stringNumbers.split(", ");

        if (splitNumbers.length != 6) {
            throw new IsNotSixNumberException("당첨번호의 갯수는 6개만 가능합니다.");
        }

        for (String winningNumber : splitNumbers) {
            this.checkNotNumber(Integer.parseInt(winningNumber));
        }
    }

    private void checkNotNumber(int number){
        if ( number < 1 || 45 < number) {
            throw new IsNotScopeInTheNumber("당첨번호는 1부터 45까지의 수만 가능합니다");
        }
    }

    public String getNumbers() {
        return numbers;
    }
}
