package lotto.domain;

import java.util.List;

public final class LottoNumbersFactory {

    private LottoNumbersFactory() {
    }

    public static LottoNumbers createAutoLottoNumbers() {
        List<Integer> nonDuplicateNumbers = LottoNumbers.createNonDuplicateNumbers();
        return LottoNumbers.newInstance(nonDuplicateNumbers);
    }

    public static LottoNumbers createManualLottoNumbers(String manualNumbers) {
        List<Integer> nonDuplicateNumbers = LottoNumbers.createNonDuplicateNumbers(manualNumbers);
        return LottoNumbers.newInstance(nonDuplicateNumbers);
    }
}
