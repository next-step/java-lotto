package Lotto.util;

import Lotto.domain.Number;

import java.util.HashMap;
import java.util.Map;

public class NumberFactory {

    private static Map<Integer, Number> pool = new HashMap<>();

    public static Number getNumber(int num) {
        Number number = pool.get(num);
        if(number == null) {
            number = new Number(num);
            pool.put(num, number);
        }
        return number;
    }
}
