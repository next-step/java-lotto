package lotto;

import java.util.Objects;

public class LottoNumber {
    private static String checkRegex = "^[0-9]\\d*";
    private int number;
    private static int numberMinimum = 1;
    private static int numberMaximum = 45;


    public LottoNumber() {
        this((int) (Math.random() * numberMaximum + numberMinimum));
    }

    public LottoNumber(String number) {
        validLottoStringNumber(number);
        new LottoNumber(Integer.parseInt(number));
    }

    public LottoNumber(int number) {
        validLottoNumber(number);
        this.number = number;
    }

    protected void validLottoStringNumber(String str) {
        if (!str.matches(checkRegex)) {
            throw new IllegalArgumentException("로또 숫자는 문자열을 넣을 수 없습니다.");
        }
    }

    protected void validLottoNumber(Integer number) {
        if (number < numberMinimum || number > numberMaximum) {
            throw new IllegalArgumentException("로또 숫자는 " + numberMinimum + " ~ " + numberMaximum + " 중에서 입력해야합니다.");
        }
    }

    public int getNumber() {
        return number;
    }

    public static int getNumberMinimum() {
        return numberMinimum;
    }

    public static int getNumberMaximum() {
        return numberMaximum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public String toString() {
        return Integer.toString(this.number);
    }


}