package lotto.application;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.NumberGeneration;

import java.util.ArrayList;
import java.util.List;

public class LottoGeneration {

    public Lottos generateLottoNumbers(int count,NumberGeneration numberGeneration){
        List<Lotto> list = new ArrayList<>();
        for(int i = 0; i< count; i++){
            list.add(new Lotto(numberGeneration));
        }
        return new Lottos(list);
    }

}
