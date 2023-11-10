package lotto.domain;

import lotto.domain.strategy.LottoNumberStrategy;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {
    private List<LottoNumber> lottoNumbers;


    public LottoMachine(LottoNumberStrategy lottoNumberStrategy,
                        BuyingAmount buyingAmount) {
        lottoNumbers = new ArrayList<>();
        for (int i = 0; i < buyingAmount.units(); i++) {
            List<Integer> numbers = lottoNumberStrategy.create();
            lottoNumbers.add(new LottoNumber(numbers));
        }
    }

    public int lottoCount() {
        return this.lottoNumbers.size();
    }

    public List<LottoNumber> getLottoNumbers() {
        return this.lottoNumbers;
    }

    public WinningResults report(WinningLottoNumber winningLottoNumber) {
        return new WinningResults(winningLottoNumber, lottoNumbers);
    }
}
