package lotto;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class LottoNumbers {
    private static List<Integer> lottoNumbers = new LinkedList<>();
    private final int LOTTO_NUMBER_MAX_COUNT = 6;
    public LottoNumbers(){
        createLottoNumbers();
    }

    private void createLottoNumbers() {
        Collections.shuffle(LottoNumberRange.getLottoNumberRange());
        int lottoRangeListIndex = 0;
        while(lottoNumbers.size()<LOTTO_NUMBER_MAX_COUNT){
            lottoNumbers.add(LottoNumberRange.getLottoNumberRange().get(lottoRangeListIndex));
            lottoRangeListIndex++;
        }
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers;
    }
}
