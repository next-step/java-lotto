package lotto.domain;

import java.util.ArrayList;
import java.util.List;
public class Lottos {

    private final List<Lotto> lottoList;

    public Lottos(List<Lotto> lottos) {
        this.lottoList = lottos;
    }

    public int size(){
        return lottoList.size();
    }

    public List<String> find(){
        List<String> list = new ArrayList<>();
        for(Lotto lotto : lottoList){
            list.add(lotto.findNumbersForPrint());
        }
        return list;
    }


}