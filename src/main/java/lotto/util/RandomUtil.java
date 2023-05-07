package lotto.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class RandomUtil {

    public static List<Integer> generateRandomList(int size, int range) {
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 1; i <= range; i++) {
            list.add(i);
        }

        Collections.shuffle(list);

        return list.subList(0, size);
    }

}
