package lotto.strategy;

import java.util.List;

public class ManualLottoGenerator implements LottoGenerator {

    private final List<Integer> manualLottoNumbers;

    public ManualLottoGenerator(List<Integer> manualLottoNumbers) {
        this.manualLottoNumbers = manualLottoNumbers;
    }

    @Override
    public List<Integer> lotto() {
        return manualLottoNumbers;
    }

}
