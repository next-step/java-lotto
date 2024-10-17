package lotto.utility;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class LottoNumberGenerator {

    private static final Random RANDOM = new Random();

    private LottoNumberGenerator() {
    }

    public static List<Integer> generateLottoNumber() {
        List<Integer> lotto = new ArrayList<>();

        for (int i = 1; i <= 6; i++) {
            lotto.add(LottoNumberGenerator.generateRandomNumber());
        }

        shuffleLottoNumber(lotto);

        return lotto;
    }

    private static int generateRandomNumber() {
        return RANDOM.nextInt(45) + 1;
    }

    private static void shuffleLottoNumber(List<Integer> lotto) {
        Collections.shuffle(lotto);
    }
}
