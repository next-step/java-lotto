package lotto.util;

import java.util.ArrayList;
import java.util.List;

public class NumberUtil {

    private final static String MINUS_VALUE_ERROR="음수는 입력될 수 없습니다.";
    public static long stringTolong(String number) {
        long parseInt = Long.parseLong(number);
        if (parseInt < 0) {
            throw new RuntimeException(MINUS_VALUE_ERROR);
        }
        return parseInt;
    }

    public static List<Integer> generatelottoNumberSet(){
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i < 46; i++){
            numbers.add(i);
        }
        return numbers;
    }
}
