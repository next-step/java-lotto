package lotto.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class RandomUtil {
    public static int getRandomValue(int range) {
        Random random = new Random();
        return random.nextInt(range);
    }

    public static List<Integer> generateRandomList(int size, int range) {
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < size; i++) {
            list.add(getRandomValue(range));
        }
        return list;
    }

}
