package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomGenerator {
    private static final Random RANDOM = new Random();

    public static List<Integer> getSixRandomNumber() {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            int num = RANDOM.nextInt(45) + 1;
            result.add(num);
        }
        return result;
    }


}
