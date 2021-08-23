package lotto.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomUtil {

    private static final int MAX_BOUNDARY = 46;
    private static final int MIN_BOUNDARY = 1;
    private static final int FIRST_ORDER = 0;
    private static final List<Integer> data = new ArrayList<>();

    static {
        for (int number = MIN_BOUNDARY; number < MAX_BOUNDARY; number++) {
            data.add(number);
        }
    }

    public static List<Integer> getRandomInteger(int size) {
        Collections.shuffle(data);
        return data.subList(FIRST_ORDER, size);
    }

}
