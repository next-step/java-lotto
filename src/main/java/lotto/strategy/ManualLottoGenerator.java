package lotto.strategy;

import lotto.domain.LottoNumber;

import java.util.List;

public class ManualLottoGenerator implements LottoGenerator {

    private final List<LottoNumber> manualLottoNumbers;

    public ManualLottoGenerator(List<LottoNumber> manualLottoNumbers) {
        this.manualLottoNumbers = manualLottoNumbers;
    }

    @Override
    public List<LottoNumber> lotto() {
        return manualLottoNumbers;
    }

}
