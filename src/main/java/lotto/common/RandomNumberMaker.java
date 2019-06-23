package lotto.common;

import java.util.Random;

public class RandomNumberMaker {
    private static final int MAX_CONTROL_NUMBER = 1;
    private static final Random RANDOM= new Random();
    
    public static int getNumber(int min, int max) {
        int maxNumberForRandom = max + MAX_CONTROL_NUMBER;
        int randomNumber = RANDOM.nextInt(maxNumberForRandom);
        while (randomNumber < min || randomNumber > max) {
            randomNumber = RANDOM.nextInt(maxNumberForRandom);
        }
        
        return randomNumber;
    }
}
