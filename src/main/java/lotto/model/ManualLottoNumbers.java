package lotto.model;


import java.util.ArrayList;
import java.util.List;

public class ManualLottoNumbers {

    private final List<LottoNumbers> manualLottoNumbers = new ArrayList<>();

    public ManualLottoNumbers(List<String> lottoNumbers) {
        for (String numbers : lottoNumbers) {
            this.manualLottoNumbers.add(new LottoNumbers(numbers));
        }
    }

    public boolean emptyNumbers() {
        return this.manualLottoNumbers.size() == 0;
    }

    public List<LottoNumbers> getManualLottoNumbers() {
        return this.manualLottoNumbers;
    }

}
