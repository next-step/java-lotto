package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoNumber {
    private List<Integer> list;
    private LottoNumberGeneratorStrategy lottoNumberGeneratorStrategy;

    public LottoNumber() {
        list = new ArrayList<Integer>();
        makeLottoNumber();
    }

    public void makeLottoNumber() {
        lottoNumberGeneratorStrategy = new LottoNumberGenerator();
        list = lottoNumberGeneratorStrategy.generateLottoNumber();
    }

    public List<Integer> getLottoNumbers() {
        return this.list;
    }
}
