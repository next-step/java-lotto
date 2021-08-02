package lotto.domain;

import java.util.*;

public class LottoMaker {
    private static final int LOTTO_MAX_NUMBER = 45;
    private static final int LOTTO_COUNT = 6;

    public static Lotto run() {
        return new Lotto(makeLotto());
    }

    public static Lotto manual(Set<Integer> lottoList) {
        return new Lotto(makeManualLotto(lottoList));
    }

    private static List<Integer> makeLotto() {
        HashSet<Integer> lottoMaker = new HashSet<>();

        while (lottoMaker.size() < LOTTO_COUNT) {
            lottoMaker.add(generateRandomNumber());
        }

        List<Integer> lotto = new ArrayList<>(lottoMaker);
        Collections.sort(lotto);

        return lotto;
    }

    private static List<Integer> makeManualLotto(Set<Integer> manualLotto) {
        List<Integer> lotto = new ArrayList<>(manualLotto);
        Collections.sort(lotto);
        return lotto;
    }

    private static int generateRandomNumber() {
        return new Random().nextInt(LOTTO_MAX_NUMBER) + 1;
    }
}
