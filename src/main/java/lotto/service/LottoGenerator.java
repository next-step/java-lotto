package lotto.service;

import java.util.*;

public class LottoGenerator {

    private static final Random RANDOM = new Random();

    private LottoGenerator() {
    }

    public static List<Integer> generateLotto() {
        Set<Integer> lottoSet = new HashSet<>();

        while (lottoSet.size() < 6) {
            lottoSet.add(LottoGenerator.generateRandomNumber());
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
