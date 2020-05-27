package com.lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ShuffleLottoExtractor implements LottoExtractor {

    @Override
    public List<Integer> extractLottoNumbers(List<Integer> availableLottoNumbers) {
        List<Integer> shuffledLottoNumbers = shuffleLottoNumbers(availableLottoNumbers);
        List<Integer> splitShuffledLottoNumbers = shuffledLottoNumbers.subList(0, 6);
        Collections.sort(splitShuffledLottoNumbers);
        return splitShuffledLottoNumbers;
    }

    private List<Integer> shuffleLottoNumbers(List<Integer> availableLottoNumbers) {
        List<Integer> copiedAvailableLottoNumbers = new ArrayList<>(availableLottoNumbers);
        Collections.shuffle(copiedAvailableLottoNumbers);
        return copiedAvailableLottoNumbers;
    }
}
