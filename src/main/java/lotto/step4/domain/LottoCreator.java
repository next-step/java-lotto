package lotto.step4.domain;

import java.util.*;

public class LottoCreator {
    private static final int LOTTO_MIN_NUMBER = 1;
    private static final int LOTTO_MAX_NUMBER = 45;
    private static final int LOTTO_START_COUNT = 1;
    private static final int LOTTO_END_COUNT = 6;
    private static final String DELIMITER = ",";
    private static final List<LottoNumber> LOTTO_CREATOR = new ArrayList<>();

    static {
        for (int i = LOTTO_MIN_NUMBER; i <= LOTTO_MAX_NUMBER; i++) {
            LOTTO_CREATOR.add(LottoNumber.of(i));
        }
    }

    public static Lottery createLotto() {
        Collections.shuffle(LOTTO_CREATOR);
        Set<LottoNumber> lotto = new HashSet<>();

        for (int i = LOTTO_START_COUNT; i <= LOTTO_END_COUNT; i++) {
            lotto.add(LOTTO_CREATOR.get(i));
        }
        return new Lottery(lotto);
    }

    public static Lottery convertToLotto(String input) {
        String[] numbers = input.split(DELIMITER);
        Set<LottoNumber> lotto = new HashSet<>();
        for (String number : numbers) {
            String trim = number.trim();
            lotto.add(LottoNumber.of(trim));
        }
        return new Lottery(lotto);
    }
}
