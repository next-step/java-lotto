package step2;

import java.util.*;

public class LottoGenerator {

    private static final List<Ball> DEFAULT_LOTTO_NUMBERS = new ArrayList<>();

    static {
        for (int i = 1; i < 46; i++) {
            DEFAULT_LOTTO_NUMBERS.add(new Ball(i));
        }
    }

    public static List<Lotto> publish(int unitCount) {
        List<Lotto> result = new ArrayList<>();
        for (int i = 0; i < unitCount; i++) {
            Collections.shuffle(DEFAULT_LOTTO_NUMBERS);
            result.add(makeLotto());
        }
        return result;
    }

    private static Lotto makeLotto() {
        return new Lotto(DEFAULT_LOTTO_NUMBERS.subList(0, 6));
    }

}
