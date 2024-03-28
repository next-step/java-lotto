package auto_lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomNumber {
    private final static int LOTTO_BOUND_NUMBER = 99;
    private final static int LOTTO_NUMBER_LIMIT = 5;
    List<Integer> randNumber = new ArrayList<>();


    public RandomNumber() {
        Random rand = new Random();
        for (int j = 0; j < LOTTO_NUMBER_LIMIT; j++) {
            randNumber.add(rand.nextInt(LOTTO_BOUND_NUMBER));
        }
    }
}
