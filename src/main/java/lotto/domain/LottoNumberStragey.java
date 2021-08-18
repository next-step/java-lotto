package lotto.domain;

import lotto.util.LottoNumberShufle;

import java.util.Set;

public class LottoNumberStragey implements RandomNumber{

    @Override
    public Set<Integer> getLottoNumber() {
        return LottoNumberShufle.getAutoNumber();
    }

}
