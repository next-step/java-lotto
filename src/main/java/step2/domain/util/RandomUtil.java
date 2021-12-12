package step2.domain.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomUtil {
    private final static int LOTTERY_NUMBER_COUNT = 6;
    private final static int MIN_VALUE = 1;
    private final static int MAX_VALUE = 45;

    private static List<Integer> randomList;

    public static List<Integer> getRandomNumbers() {
        init();
        Collections.shuffle(randomList);

        List<Integer> extract = randomList.subList(0, LOTTERY_NUMBER_COUNT);
        extract.sort(Integer::compareTo);

        return extract;
    }

    private static void init() {
        if (randomList == null) {
            List<Integer> list = new ArrayList<>();

            for (int idx = MIN_VALUE; idx <= MAX_VALUE; idx++) {
                list.add(idx);
            }

            randomList = list;
        }
    }
}
