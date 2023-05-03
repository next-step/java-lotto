package lotto;

import java.security.InvalidParameterException;
import java.util.Random;

public class LottoNumber implements Comparable<LottoNumber> {

    public static final int MAX = 45;
    public static final int MIN = 1;
    private final int number;

    public LottoNumber() {
        Random random = new Random();
        this.number = random.nextInt(MAX);
    }

    public LottoNumber(int number) {
        if(number > MAX || number < MIN){
            throw new InvalidParameterException("로또 번호는 1과 45 사이 숫자만 가능합니다");
        }
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public int compareTo(LottoNumber other) {
        return Integer.compare(this.number, other.number);
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }
}
