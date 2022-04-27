package lotto.util;

import lotto.model.Number;

import java.util.Random;

public class Roulette {

    private static final Random ROULETTE = new Random();
    private static final Number MIX_NUMBER = new Number(1);
    private static final Number MAX_NUMBER = new Number(45);

    private Roulette() {
    }

    public static Number spin() {
        int randomNumber = ROULETTE.nextInt(MAX_NUMBER.getValue());
        return MIX_NUMBER.add(new Number(randomNumber));
    }
}
