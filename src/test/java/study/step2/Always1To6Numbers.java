package study.step2;

import java.util.Random;

public class Always1To6Numbers extends Random {

    @Override
    public int nextInt(int bound) {
        return bound - 1;
    }
}
