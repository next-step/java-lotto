package step2.dto;

import java.util.Objects;

public class WinningNumber {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private final int myWinningNumber;

    public WinningNumber(int myWinningNumber) {
        validWinningNumberOrElseThrow(myWinningNumber);

        this.myWinningNumber = myWinningNumber;
    }

    public WinningNumber(String winningNumberText) throws NumberFormatException {
        this(Integer.parseInt(winningNumberText));
    }

    private void validWinningNumberOrElseThrow(int number) {
        if(MIN_NUMBER > number || number > MAX_NUMBER) {
            throw new IllegalArgumentException("1 ~ 45 숫자를 입력해주세요");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        WinningNumber that = (WinningNumber) o;
        return myWinningNumber == that.myWinningNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(myWinningNumber);
    }

    @Override
    public String toString() {
        return String.valueOf(myWinningNumber);
    }
}
