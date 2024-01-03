package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class AllLottoNumber {

    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;

    private static final int LOTTO_NUMBERS_LENGTH = 6;

    private static final List<LottoNumber> allLottoNumber;

    static {
        allLottoNumber = initializeAllLottoNumber();
    }

    private static List<LottoNumber> initializeAllLottoNumber() {
        List<LottoNumber> allLottoNumber = new ArrayList<>();
        for (int i = MIN_LOTTO_NUMBER; i <= MAX_LOTTO_NUMBER; i++) {
            allLottoNumber.add(new LottoNumber(i));
        }
        return allLottoNumber;
    }

    public static Set<LottoNumber> randomLottoNumber() {
        Collections.shuffle(allLottoNumber);
        return allLottoNumber.stream().limit(LOTTO_NUMBERS_LENGTH).collect(Collectors.toSet());
    }

}
