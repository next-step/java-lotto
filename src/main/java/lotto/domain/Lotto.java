package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lotto {

    private List<Integer> myLottoNumberList;
    private LottoNumber lottoNumbers;

    public Lotto(int countOfLotto) {
        myLottoNumberList = new ArrayList<>();
        lottoNumbers = new LottoNumber();
        for (int i = 0; i < countOfLotto; i++) {
        }
    }
}
