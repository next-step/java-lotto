package lotto.domain;

import java.util.List;

public class LottoList {

    private List<Lotto> lottoList;

    public List<Lotto> getLottoList(){
        return lottoList;
    }

    public LottoList(List<Lotto> list){
        this.lottoList = list;
    }
    
}