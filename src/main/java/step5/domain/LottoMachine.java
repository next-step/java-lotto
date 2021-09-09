package step5.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class LottoMachine {
    public static final Random RD = new Random();
    private static final Integer NUMBER_OF_LOTTO_NUMBERS = 6;
    private static final Integer MIN_OF_LOTTO_NUMBER = 1;
    private static final Integer MAX_OF_LOTTO_NUMBER = 45;

    private List<Integer> fullLottoNumber = new ArrayList<>();

    public LottoMachine() {
        for (int i = MIN_OF_LOTTO_NUMBER; i <= MAX_OF_LOTTO_NUMBER; i++) {
            fullLottoNumber.add(i);
        }
    }

    public List<Integer> issue() {
        Collections.shuffle(fullLottoNumber);
        return fullLottoNumber.subList(0, 6);
    }
}
