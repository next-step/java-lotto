package lotto;

import java.util.*;

public class LottoMaker {
    private static final int LOTTO_MAX_NUMBER = 45;
    private static final int LOTTO_COUNT = 6;

    public List<Integer> makeLotto() {
        HashSet<Integer> lottoMaker = new HashSet<>();

        while (lottoMaker.size() < LOTTO_COUNT) {
            lottoMaker.add(generateRandomNumber());
        }

        List<Integer> lotto = new ArrayList<>(lottoMaker);
        Collections.sort(lotto);

        return lotto;
    }

    private static int generateRandomNumber() {
        return new Random().nextInt(LOTTO_MAX_NUMBER) + 1;
    }
}
