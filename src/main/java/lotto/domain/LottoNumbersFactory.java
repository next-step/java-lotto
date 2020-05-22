package lotto.domain;

import java.util.List;

public final class LottoNumbersFactory {

    private LottoNumbersFactory() {
    }

    public static LottoNumbers createLottoNumbers() {
        List<Integer> nonDuplicateNumbers = LottoNumbers.createNonDuplicateNumbers();
        return LottoNumbers.newInstance(nonDuplicateNumbers);
    }
}
