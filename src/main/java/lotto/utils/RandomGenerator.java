package lotto.utils;

import java.util.Random;

public class RandomGenerator {
    private static final Random RANDOM = new Random();
    private static final int MAX_NUMBER = 45;


    public static int genRandomNum(){
        return RANDOM.nextInt(MAX_NUMBER) + 1;
    }

}
