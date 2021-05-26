package study.ascii92der.lotto.step3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoGenerator {

    public static final int LOTTO_MINIMUM_NUMBER = 1;
    public static final int LOTTO_MAXIMUM_NUMBER = 45;
    public static final int LOTTO_INDEX_START = 0;
    public static final int LOTTO_INDEX_END = 6;

    private final List<String> lottoList;

    public LottoGenerator() {
        lottoList = new ArrayList<>();

        for (int lottoNumber = LOTTO_MINIMUM_NUMBER; lottoNumber <= LOTTO_MAXIMUM_NUMBER; lottoNumber++) {
            lottoList.add(String.valueOf(lottoNumber));
        }
    }

    public List<String> generate() {
        Collections.shuffle(lottoList);
        return lottoList.subList(LOTTO_INDEX_START, LOTTO_INDEX_END);
    }
}
