package lotto.model;


import java.util.ArrayList;
import java.util.List;

public class ManualLottoNumbers {

    private List<LottoNumbers> manualLottoNumbers;

    public ManualLottoNumbers setManualLottoNumbers(List<String> manualNumbers) {
        manualLottoNumbers = new ArrayList<>();
        for (String numbers : manualNumbers) {
            manualLottoNumbers.add(new LottoNumbers(numbers));
        }
        return this;
    }

    public List<LottoNumbers> getManualLottoNumbers() {
        return this.manualLottoNumbers;
    }

}
