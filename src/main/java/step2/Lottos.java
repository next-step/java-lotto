package step2;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    public List<Lotto> lottoList = new ArrayList<>();

    public Lottos(int money, Generator lottoGenerator) {
        for(int i = 1; i <= getLottoCnt(money); i++) {
            lottoList.add(new Lotto(lottoGenerator));
        }
    }

    public int getLottoCnt(int money) {
        return money/1000;
    }
}
