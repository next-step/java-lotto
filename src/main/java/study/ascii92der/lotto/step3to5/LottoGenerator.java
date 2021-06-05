package study.ascii92der.lotto.step3to5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoGenerator {

    public static final int LOTTO_MINIMUM_NUMBER = 1;
    public static final int LOTTO_MAXIMUM_NUMBER = 45;
    public static final int LOTTO_INDEX_START = 0;
    public static final int LOTTO_INDEX_END = 6;

    private final List<Integer> numberList;

    public LottoGenerator() {
        numberList = new ArrayList<>();
        for (int lottoNumber = LOTTO_MINIMUM_NUMBER; lottoNumber <= LOTTO_MAXIMUM_NUMBER; lottoNumber++) {
            numberList.add(lottoNumber);
        }
    }

    public Lotto generate() {
        Collections.shuffle(this.numberList);
        return new Lotto(this.numberList.subList(LOTTO_INDEX_START, LOTTO_INDEX_END));
    }

    public Lottos generateLottos(LottoPrice lottoPrice) {
        List<Lotto> lottosList = new ArrayList<>();
        for (int i = 0; i < lottoPrice.lottoCount(); i++) {
            lottosList.add(this.generate());
        }
        return new Lottos(lottosList);
    }

}
