package lotto.domain;

public class WinningNumber {

    private final int number;

    public WinningNumber(int number) {
        if (Rule.isNotInRange(number)) {
            throw new IllegalArgumentException("당첨 번호는 1부터 45 사이의 숫자만 가능합니다.");
        }
        this.number = number;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }

        if (!(object instanceof WinningNumber)) {
            return false;
        }

        WinningNumber that = (WinningNumber) object;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return number;
    }

}
