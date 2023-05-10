package lotto.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;


public class RandomUtil {

    public static Set<Integer> generateRandomList(int size, int range) {
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 1; i <= range; i++) {
            list.add(i);
        }

        Collections.shuffle(list);

        return Set.copyOf(list.subList(0, size));
    }

}
