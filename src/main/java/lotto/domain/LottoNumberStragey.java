package lotto.domain;

import lotto.util.LottoNumberShufle;

import java.util.List;

public class LottoNumberStragey implements RandomNumber{

    @Override
    public List<Integer> getLottoNumber() {
        return LottoNumberShufle.getAutoNumber();
    }

}
