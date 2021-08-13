package domain;

import java.util.ArrayList;
import java.util.List;

public class LottoNumbers {

    private List<Integer> lottoNumbers = new ArrayList<>();

    public LottoNumbers(PickNumberStrategy pickNumberStrategy) {
        lottoNumbers = pickNumberStrategy.makeLottoNumber();
    }

    public List<Integer> getValues() {
        return lottoNumbers;
    }
}
