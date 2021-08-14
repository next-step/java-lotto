package lotto.common;

import lotto.domain.LottoNumber;

import java.util.ArrayList;
import java.util.List;

public class ManualNumberGenerator implements NumberGenerator {
    private final String[] manualLottoNumber;
    private final List<LottoNumber> manualLottoNumbers;

    public ManualNumberGenerator(String[] manualLottoNumber) {
        this.manualLottoNumber = manualLottoNumber;
        this.manualLottoNumbers = generateNumber();
    }

    @Override
    public List<LottoNumber> generateNumber() {
        List<LottoNumber> manualLottoNumbers = new ArrayList<>();
        for (String number : manualLottoNumber) {
            LottoNumber lottoNumber = new LottoNumber(number);
            manualLottoNumbers.add(lottoNumber);
        }
        return manualLottoNumbers;
    }
}
