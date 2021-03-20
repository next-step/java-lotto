package study.step2.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoFactory {
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final int LOTTO_SIZE = 6;

    private static List<Integer> allLottoNumbers = new ArrayList<>();

    static {
        for(int i=MIN_LOTTO_NUMBER; i<=MAX_LOTTO_NUMBER; i++) {
            allLottoNumbers.add(i);
        }
    }

    public static Lotto createLotto() {
        Collections.shuffle(allLottoNumbers);
        return new Lotto(allLottoNumbers.stream()
            .limit(LOTTO_SIZE)
            .collect(Collectors.toList()));
    }
}
