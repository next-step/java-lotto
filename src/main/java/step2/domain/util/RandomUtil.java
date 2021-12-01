package step2.domain.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomUtil {
    private final static int MIN_VALUE = 1;
    private final static int MAX_VALUE = 45;

    private static List<Integer> randomList;

    public static int getRandomNumber() {
        make();

        Collections.shuffle(randomList);
        return randomList.get(0);
    }

    public static List<Integer> getRandomNumbers() {
        make();

        Collections.shuffle(randomList);
        List<Integer> extract = randomList.subList(0, 6);
        extract.sort(Integer::compareTo);

        return extract;
    }

    private static void make() {
        if (randomList == null) {
            List<Integer> list = new ArrayList<>();

            for (int i = MIN_VALUE; i <= MAX_VALUE; i++) {
                list.add(i);
            }

            randomList = list;
        }
    }
}
