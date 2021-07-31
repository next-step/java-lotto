package lotto;

import java.util.LinkedList;
import java.util.List;

public class LottoNumberRange {
    private static List<Integer> lottoNumberRangeList = new LinkedList<>();
    private static LottoNumberRange lottoNumberRange = new LottoNumberRange();
    private static final int LOTTO_START_NUMBER = 1;
    private static final int LOTTO_END_NUMBER = 45;

    private LottoNumberRange(){
        for(int i=LOTTO_START_NUMBER; i<=LOTTO_END_NUMBER; i++){
            lottoNumberRangeList.add(i);
        }
    }

    public static List<Integer> getLottoNumberRange() {
        return lottoNumberRangeList;
    }
}
