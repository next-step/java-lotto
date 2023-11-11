package lotto.domain;

import java.util.ArrayList;
import java.util.List;
public class Lottos {

    private final List<Lotto> lottoList;

    public Lottos(int count, NumberGeneration numberGeneration) {
        this.lottoList = generate(count, numberGeneration);
    }

    private List<Lotto> generate(int count, NumberGeneration numberGeneration) {
        List<Lotto> list = new ArrayList<>();
        for(int i = 0; i< count; i++){
            list.add(new Lotto(numberGeneration));
        }
        return list;
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