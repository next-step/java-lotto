package lotto.util;

import java.util.ArrayList;
import java.util.List;

public class LottoBasicNumber {

    private static final int MAX_NUMBER = 45;

    //정적필드 초기화 https://blog.hanumoka.net/2017/09/13/java-20170913-java-static-initialization/
    public static final List<Integer> numbers = new ArrayList<>();
    static {
        for (int i = 1; i <= MAX_NUMBER; i++) {
            LottoBasicNumber.numbers.add(i);
        }
    }
}
