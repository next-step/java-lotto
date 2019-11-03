package lotto;

import java.util.*;

public class Lotto {
    private static final int LOTTO_MAX_NUMBER = 45;
    private static final int LOTTO_MIN_NUMBER = 1;
    private static final int LOTTO_GET_NUMBER = 6;
    private static final int LOTTO_INIT_NUMBER = 0;
    private static List<Integer> allLottoNumber;
    private List<Integer> lottoNumber;

    static {
        allLottoNumber = new ArrayList<>();
        for (int i = LOTTO_MIN_NUMBER; i <= LOTTO_MAX_NUMBER; i++) {
            allLottoNumber.add(i);
        }
    }

    public Lotto() {
        this.lottoNumber = new ArrayList<>();
    }

    public void selectLottoNumber() {
        Collections.shuffle(allLottoNumber);
        for (int i = LOTTO_INIT_NUMBER; i < LOTTO_GET_NUMBER; i++) {
            this.lottoNumber.add(allLottoNumber.get(i));
        }
    }

    public List<Integer> getLottoNumber() {
        return lottoNumber;
    }
}
