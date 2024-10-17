package lotto.utility;

import java.util.*;

public class LottoNumberGenerator {

    private static final Random RANDOM = new Random();

    private LottoNumberGenerator() {
    }

    public static List<Integer> generateLottoNumber() {
        Set<Integer> lottoSet = new HashSet<>();

        while(lottoSet.size() < 6) {
            lottoSet.add(LottoNumberGenerator.generateRandomNumber());
        }

        List<Integer> lotto = new ArrayList<>(lottoSet);

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
