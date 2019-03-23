package lotto.utils;

import java.util.Random;

public class RandomUtils {

    public static final int LOTTERY_MAX_NUMBER = 45;
    public static final int LOTTERY_MIN_NUMBER = 1;

    public static int random(){
       return  (new Random().nextInt(LOTTERY_MAX_NUMBER)) + LOTTERY_MIN_NUMBER;
    }
}
