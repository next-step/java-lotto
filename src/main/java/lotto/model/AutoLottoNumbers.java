package lotto.model;


import java.util.ArrayList;
import java.util.List;

public class AutoLottoNumbers {

    private List<LottoNumbers> autoLottoNumbers = new ArrayList<>();

    public AutoLottoNumbers(int gameCount) {
        for (int count = 0; count < gameCount; count++) {
            LottoNumbers lottoNumbers = new LottoNumbers();
            autoLottoNumbers.add(lottoNumbers.generateNumbers());
        }
    }

    public List<LottoNumbers> getAutoLottoNumbers() {
        return this.autoLottoNumbers;
    }
}
