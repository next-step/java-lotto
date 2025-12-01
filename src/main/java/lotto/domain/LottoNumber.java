package lotto.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class LottoNumber {
    private static final int MIN = 1;
    private static final int MAX = 45;
    private static final Map<Integer, LottoNumber> CACHE_NUM = new HashMap<>();

    static{
        for (int i = MIN; i <= MAX; i++){
            CACHE_NUM.put(i, new LottoNumber(i));
        }
    }

    private final int number;

    public LottoNumber(int number) {
        validation(number);
        this.number = number;
    }

    public static LottoNumber valueOf(String number){
        validation(Integer.parseInt(number));
        return CACHE_NUM.get(Integer.parseInt(number));
    }

    public static LottoNumber valueOf(int number){
        validation(number);
        return CACHE_NUM.get(number);
    }

    private static void validation(int number) {
        if (number < MIN || number > MAX) {
            throw new RuntimeException("로또 번호는 1부터 45입니다.");
        }
    }

    public int value() {
        return this.number;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(number);
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }
}
