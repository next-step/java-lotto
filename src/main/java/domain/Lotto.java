package domain;

import java.util.List;

public class Lotto {
    List<Integer> lottoNumber;

    public Lotto(List<Integer> list){
        this.lottoNumber= list;
    }


    public List<Integer> getLottoNumber() {
        return lottoNumber;
    }
}
