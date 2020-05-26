package lotto.domain;

import java.util.List;

public final class LottoNumberFactory {

    private LottoNumberFactory() {
    }

    public static LottoNumber createAutoLottoNumbers() {
        List<Integer> nonDuplicateNumbers = LottoNumber.createNonDuplicateNumbers();
        return LottoNumber.newInstance(nonDuplicateNumbers, CreationType.AUTO);
    }

    public static LottoNumber createManualLottoNumbers(String manualNumbers) {
        List<Integer> nonDuplicateNumbers = LottoNumber.createNonDuplicateNumbers(manualNumbers);
        return LottoNumber.newInstance(nonDuplicateNumbers, CreationType.MANUAL);
    }
}
