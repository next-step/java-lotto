package refactoringlotto;

import refactoringlotto.random.LottoGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class AllRoundLottoNumbers {
    private List<LottoNumbers> lottoNumbersList = new ArrayList<>();

    public static AllRoundLottoNumbers initAllRoundLottoNumbers(LottoGenerator lottoGenerator, int tryCount) {
        List<LottoNumbers> lottoNumbersList = new ArrayList<>();
        for ( int i =0 ; i< tryCount ; i++) {
            lottoNumbersList.add(new LottoNumbers(lottoGenerator.executeStrategy()));
        }
        return new AllRoundLottoNumbers(lottoNumbersList);
    }

    public AllRoundLottoNumbers(List<LottoNumbers> lottoNumbersList) {
        this.lottoNumbersList = lottoNumbersList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AllRoundLottoNumbers that = (AllRoundLottoNumbers) o;
        return Objects.equals(lottoNumbersList, that.lottoNumbersList);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(lottoNumbersList);
    }
}
