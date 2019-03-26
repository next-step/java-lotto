package domain;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class LottoNumber implements Comparable<LottoNumber>{
    public static final Integer MIN_NUMBER = 1;
    public static final Integer MAX_NUMBER = 45;

    private final Integer number;

    private static Map<Integer, LottoNumber> instances = new HashMap<>();

    static {
        IntStream.rangeClosed(MIN_NUMBER, MAX_NUMBER)
            .forEach(i -> instances.put(i, new LottoNumber(i)));
    }

    public static LottoNumber of(Integer number){
        if(number < MIN_NUMBER || number > MAX_NUMBER){
            throw new IllegalArgumentException();
        }

        return instances.get(number);
    }

    private LottoNumber(Integer number) {
        this.number = number;
    }

    public Integer getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null){
            return false;
        }

        if(obj == this){
            return true;
        }

        if(obj.getClass() == getClass()){
            LottoNumber lottoNumber = (LottoNumber)obj;

            return lottoNumber.number.equals(number);
        }

        return false;
    }

    @Override
    public int hashCode() {
        return number.hashCode();
    }

    @Override
    public int compareTo(LottoNumber otherLottoNumber) {
        return number.compareTo(otherLottoNumber.getNumber());
    }
}
