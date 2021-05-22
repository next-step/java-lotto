package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoNumberList {
    private List<LottoNumber> lottoNumberList;

    public LottoNumberList() {
        lottoNumberList = new ArrayList<LottoNumber>();
    }

    public void appendLottoNumber(LottoNumber number) {
        lottoNumberList.add(number);
    }

    public int count() {
        return lottoNumberList.size();
    }

    public LottoNumber get(int index) {
        return lottoNumberList.get(index);
    }
}
