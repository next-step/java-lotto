package lotto.domain;

public class NumberOfLottos {

    private final int number;

    public NumberOfLottos(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("수동 로또 개수가 음수가 될 수 없습니다.");
        }

        this.number = number;
    }

    public int number() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NumberOfLottos number1 = (NumberOfLottos) o;

        return number == number1.number;
    }

    @Override
    public int hashCode() {
        return number;
    }
}
