package lotto.application;

import lotto.util.LottoNumberRange;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CreateShffledLottoNumbers implements CreateLottoNumbersStrategy {
    private final int LOTTO_NUMBER_MAX_COUNT = 6;

    @Override
    public List<Integer> getNumbersList() {
        Collections.shuffle(LottoNumberRange.getLottoNumberRange());
        return LottoNumberRange.getLottoNumberRange()
                .stream()
                .limit(LOTTO_NUMBER_MAX_COUNT)
                .sorted()
                .collect(Collectors.toList());
    }
}
