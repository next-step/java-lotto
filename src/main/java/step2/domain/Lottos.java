package step2.domain;

import java.util.ArrayList;
import java.util.List;

public class Lottos {

    private List<Lotto> lottoList;

    public Lottos createLottoList(int count) {
        lottoList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottoList.add(new Lotto());
        }
        return this;
    }

    public int lottoCount() {
        return lottoList.size();
    }

}
