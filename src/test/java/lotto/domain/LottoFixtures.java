package lotto.domain;

import java.util.Arrays;

public class LottoFixtures {

    public static Lotto win() {
        Lotto lotto = new Lotto(Arrays.asList(new Integer[]{1, 5, 11, 18, 20, 43}));
        return lotto;
    }

    public static Lotto unrank() {
        Lotto lotto = new Lotto(Arrays.asList(new Integer[]{2, 5, 14, 33, 37, 45}));
        return lotto;
    }

    public static Lotto three() {
        Lotto lotto = new Lotto(Arrays.asList(new Integer[]{1, 5, 11, 30, 32, 42}));
        return lotto;
    }

    public static Lotto four() {
        Lotto lotto = new Lotto(Arrays.asList(new Integer[]{1, 5, 11, 18, 33, 39}));
        return lotto;
    }

    public static Lotto five() {
        Lotto lotto = new Lotto(Arrays.asList(new Integer[]{1, 5, 11, 18, 20, 33}));
        return lotto;
    }

    public static Lotto six() {
        Lotto lotto = new Lotto(Arrays.asList(new Integer[]{1, 5, 11, 18, 20, 43}));
        return lotto;
    }

    public static int matchedBonusNumber() {
        return 33;
    }

    public static int unmatchedBonusNumber() {
        return 44;
    }
}
