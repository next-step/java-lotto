package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoList {

    private List<Lotto> lottoList;

    public List<Lotto> getLottoList(){
        return lottoList;
    }

    public int getLottoSize(){
        return lottoList.size();
    }

    public LottoList createLottoList(int size){
        List<Lotto> tempList = new ArrayList<>();
        for(int i = 0; i < size; i++){
            Lotto lotto = new Lotto().createLotto();
            tempList.add(lotto);
        }
        LottoList lottoList = new LottoList(tempList);
        return lottoList;
    }

    public LottoList(List<Lotto> winningList){
        this.lottoList = winningList;
    }

    public LottoList(){
    }
    
}