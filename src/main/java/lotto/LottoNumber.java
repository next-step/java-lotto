package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoNumber {
    private List<Integer> list;

    public LottoNumber(LottoNumberGeneratorStrategy lottoNumberGeneratorStrategy) {
        list = new ArrayList<Integer>();
        makeLottoNumber(lottoNumberGeneratorStrategy);
    }

    public void makeLottoNumber(LottoNumberGeneratorStrategy lottoNumberGeneratorStrategy) {
        list = lottoNumberGeneratorStrategy.generateLottoNumber();
    }

    public List<Integer> getLottoNumbers() {
        return this.list;
    }
}
