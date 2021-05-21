package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoNumber {
    private List<Integer> list;
    private LottoNumberGenerator lottoNumberGenerator;

    public LottoNumber() {
        list = new ArrayList<Integer>();
        lottoNumberGenerator = new LottoNumberGenerator();
        list = lottoNumberGenerator.generateLottoNumber();
    }

    public List<Integer> getLottoNumbers() {
        return this.list;
    }
}
