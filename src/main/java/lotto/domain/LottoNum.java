package lotto.domain;

import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

public class LottoNum implements Comparable<LottoNum>{

    private static final int MAXIMUM = 45;
    private static final int MINIMUM = 1;
    private static final Map<Integer, LottoNum> cacheMap = new HashMap<>();

    private int number;

    private LottoNum(int number) {
        validation(number);
        this.number = number;
    }

    public static LottoNum of(int number) {
        if (!cacheMap.containsKey(number)) {
            cacheMap.put(number, new LottoNum(number));
        }
        return cacheMap.get(number);
    }

    public static LottoNum of(String number){
        return LottoNum.of(Integer.valueOf(number));
    }

    public int getNumber() {
        return number;
    }

    private void validation(int number) {
        if (number < MINIMUM || number > MAXIMUM) {
            throw new IllegalArgumentException("숫자 범위 초과");
        }
    }

    @Override
    public int compareTo(@NotNull LottoNum other) {
        return this.getNumber() - other.getNumber();
    }

    @Override
    public String toString() {
        return String.valueOf(number) ;
    }
}
