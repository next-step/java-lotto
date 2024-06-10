package Lotto.domain;

import java.util.List;

public class Lotto {
    private final List<Integer> lottoNumber;

    public Lotto(List<Integer> lottoNumber) {
        this.lottoNumber = lottoNumber;
    }

    public List<Integer> getLottoNumber(){
        return lottoNumber;
    }
}
