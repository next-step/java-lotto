package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LottoNumberList {
    public final List<LottoNumber> lottoNumberList = makeLottoNumberList();

    static List<LottoNumber> makeLottoNumberList() {
        List<LottoNumber> lottoNumberList = new ArrayList<>();
        for (int i = 1; i <= 45; i++) {
            lottoNumberList.add(new LottoNumber(i));
        }
        return lottoNumberList;
    }

    public List<LottoNumber> getLottoNumberList() {
        return lottoNumberList;
    }

}
