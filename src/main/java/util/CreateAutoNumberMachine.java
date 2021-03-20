package util;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class CreateAutoNumberMachine {

    private static Random random = new Random();
    private static final int SIZE = 6;
    private static final int LOW_BOUND = 1;
    private static final int HIGH_BOUND = 45;

    public static List<Integer> create(){
        return Arrays.stream(
            random
                .ints(SIZE, LOW_BOUND, HIGH_BOUND)
                .toArray())
                .boxed()
                .collect(Collectors.toList());
    }
}
