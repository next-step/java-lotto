package lotto.common;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;

import java.util.*;

public class AutoGenerator {
    private static final List<Integer> DUMMY_LOTTO_NUMBERS = new ArrayList<>();
    private static Random random = new Random();

    static {
        for (int number = LottoNumber.START_NUMBER; number <= LottoNumber.END_NUMBER; number++) {
            DUMMY_LOTTO_NUMBERS.add(number);
        }
    }

    private AutoGenerator() {}

    public static List<Lotto> generateByLottoCount(Integer lottoCount) {
        checkLottoCount(lottoCount);
        List<Lotto> lottoList = new ArrayList<>();
        for (int index = 0; index < lottoCount; index++) {
            lottoList.add(generate());
        }
        return lottoList;
    }

    private static void checkLottoCount(Integer lottoCount) {
        if (lottoCount == null || lottoCount == 0) {
            throw new IllegalArgumentException("Pay more than 1000 won");
        }
    }

    public static Lotto generate() {
        Collections.shuffle(DUMMY_LOTTO_NUMBERS, random);
        List<Integer> lottoNumbers = new ArrayList<>();
        for (int index = 0; index < 6; index++) {
            lottoNumbers.add(DUMMY_LOTTO_NUMBERS.get(index));
        }
        return new Lotto(lottoNumbers);
    }
}
