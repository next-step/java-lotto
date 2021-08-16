package lotto.model;


import java.util.ArrayList;
import java.util.List;

public class AutoLottoNumbers {

    private final List<LottoNumbers> autoLottoNumbers = new ArrayList<>();
    private final LottoNumbers lottoNumbers = new LottoNumbers();
    public AutoLottoNumbers(int gameCount) {
        for (int count = 0; count < gameCount; count++) {
            autoLottoNumbers.add(lottoNumbers.generateNumbers());
        }
    }

    public List<LottoNumbers> getAutoLottoNumbers() {
        return this.autoLottoNumbers;
    }
}
