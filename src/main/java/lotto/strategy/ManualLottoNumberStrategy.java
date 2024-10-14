package lotto.strategy;

import java.util.List;


public class ManualLottoNumberStrategy implements LottoNumberStrategy {
    private final List<Integer> manualLottoNumbers;

    public ManualLottoNumberStrategy(List<Integer> manualLottoNumbers) {
        this.manualLottoNumbers = manualLottoNumbers;
    }

    @Override
    public List<Integer> generate() {
        return manualLottoNumbers;
    }

}
