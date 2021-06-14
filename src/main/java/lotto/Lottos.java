package lotto;

import java.util.List;

public class Lottos {
    public List<Lotto> LottoLists;

    public Lottos(int num,List<Integer> lottoNumbers){
        Lotto lotto = new Lotto();
        for (int i = 0; i < num; i++) {
            LottoLists.add(lotto);
        }
    }
}
