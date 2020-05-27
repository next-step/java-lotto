package step2;


import step0.Generating;
import step0.RandomGenerableStrategy;

public class LottoGenerator extends Generating {

    public static final int LOTTO_FIRST_NUMBER = 1;
    public static final int LOTTO_LAST_NUMBER = 45;

    public LottoGenerator() {
        this.setGenerableStrategy(new RandomGenerableStrategy());
    }
}
