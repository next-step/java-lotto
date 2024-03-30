package lotto;

import java.util.List;

public class ManualLottoNumberStrategy implements LottoNumberStrategy {

    private final List<Integer> lottoNumbers;

    public ManualLottoNumberStrategy(List<Integer> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    @Override
    public List<Integer> numbers() {
        return lottoNumbers;
    }
}
