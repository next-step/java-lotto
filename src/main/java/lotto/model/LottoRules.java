package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class LottoRules {

    private final int START_NUM = 1;
    private final int LAST_NUM = 45;
    private final int LOTTO_COUNT = 6;
    private final int LOTTO_PRICE = 1000;
    private final List<Integer> LOTTO_NUMS;

    public LottoRules() {
        List<Integer> lottoNums = new ArrayList<>();
        for (int i = START_NUM; i <= LAST_NUM; i++) {
            lottoNums.add(i);
        }
        this.LOTTO_NUMS = lottoNums;
    }

    public List<Integer> getLottoNums() {
        return LOTTO_NUMS;
    }

    public int getLottoPrice() {
        return LOTTO_PRICE;
    }

    public int getLottoCount() {
        return LOTTO_COUNT;
    }

    public int getStartNum() {
        return START_NUM;
    }

    public int getLastNum() {
        return LAST_NUM;
    }
}
