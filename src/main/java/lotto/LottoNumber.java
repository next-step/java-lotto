package lotto;

import java.util.Objects;

public class LottoNumber implements Comparable{
    private final static int MIN_NUMBER = 1;
    private final static int MAX_NUMBER = 45;

    private int number;

    public LottoNumber(int number){
        this.number = number;
    }

    public int getValue(){
        return this.number;
    }
    public static boolean validateLottoNumber(int lottoNumber) {
        if (lottoNumber < MIN_NUMBER || lottoNumber > MAX_NUMBER) {
            throw new IllegalArgumentException("유효한 번호가 아닙니다.");
        }
        return true;
    }

    public boolean validateLottoNumber() {
        if (this.number < MIN_NUMBER || this.number > MAX_NUMBER) {
            throw new IllegalArgumentException("유효한 번호가 아닙니다.");
        }
        return true;
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
    public int compareTo(Object o) {
        if(((LottoNumber) o).number == this.number){
            return 0;
        }
        if(((LottoNumber) o).number < this.number){
            return 1;
        }
        return -1;
    }
}
