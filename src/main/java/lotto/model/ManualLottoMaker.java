package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class ManualLottoMaker {
    private static final int NUMBER_OF_LOTTO_NUMBERS = 6;

    public Lotto createLotto(String manualNumbers) {
        String[] splitManualNumbers = splitBySeparator(manualNumbers);
        List<LottoNumber> lottoNumbers = addLottoNumbers(splitManualNumbers);
        return new Lotto(lottoNumbers);
    }

    private String[] splitBySeparator(String manualNumbers) {
        String separator = ", ";
        return manualNumbers.split(separator);
    }

    private List<LottoNumber> addLottoNumbers(String[] manualNumbers) {
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        for (int i = 0; i < NUMBER_OF_LOTTO_NUMBERS; i++) {
            lottoNumbers.add(LottoNumber.of(Integer.parseInt(manualNumbers[i])));
        }
        return lottoNumbers;
    }
}
