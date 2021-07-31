package lotto.application;

import lotto.util.LottoNumberRange;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class CreateShffledLottoNumbers implements CreateLottoNumbersStrategy {
    private final int LOTTO_NUMBER_MAX_COUNT = 6;

    @Override
    public List<Integer> getNumbersList() {
        List<Integer> lottoNumbers = new LinkedList<>();
        Collections.shuffle(LottoNumberRange.getLottoNumberRange());
        int lottoRangeListIndex = 0;
        while(lottoNumbers.size()<LOTTO_NUMBER_MAX_COUNT){
            lottoNumbers.add(LottoNumberRange.getLottoNumberRange().get(lottoRangeListIndex));
            lottoRangeListIndex++;
        }
        Collections.sort(lottoNumbers);
        return lottoNumbers;
    }
}
