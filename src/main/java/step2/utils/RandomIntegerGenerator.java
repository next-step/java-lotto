package step2.utils;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RandomIntegerGenerator {

    private static final int RANDOM_LIMIT = 45;
    private static final int LENGTH = 6;

    public static List<Integer> getRandomInteger() {
        Random rand = new Random();
        return Stream.iterate(RANDOM_LIMIT, n -> rand.nextInt(RANDOM_LIMIT) + 1).limit(LENGTH).collect(Collectors.toList());
    }
}
