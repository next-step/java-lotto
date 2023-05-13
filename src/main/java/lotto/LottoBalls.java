package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoBalls {
    private static List<Number> numberList;
    private static final int MAX_NUMBER = 45;

    public static void init() {
        List<Number> list = new ArrayList<>();
        for (int i = 1; i < MAX_NUMBER; i++) {
            list.add(Number.createNumber(i));
        }
        numberList = list;
    }

    public LottoBalls() {
        init();
    }

    public LottoBalls(List<Number> list) {
        numberList = list;
    }

    public static List<Number> getLottoNumbers(){
        return Collections.unmodifiableList(numberList);
    }
}
