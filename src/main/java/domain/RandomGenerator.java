package domain;

import java.util.*;

public class RandomGenerator {
    private static final Random RANDOM = new Random();

    public static List<Integer> getSixRandomNumber() {
        Set<Integer> result = new HashSet<>();
        while(result.size() != 6) {
            int num = RANDOM.nextInt(45) + 1;
            result.add(num);
        }
        return new ArrayList<>(result);
    }


}
