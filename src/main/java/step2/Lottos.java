package step2;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    public List<Lotto> lottoList = new ArrayList<>();

    public Lottos(int money, Machine numberMachine) {
        for(int i = 1; i <= getLottoCnt(money); i++) {
            lottoList.add(new Lotto(numberMachine));
        }
    }

    public int getLottoCnt(int money) {
        return money/1000;
    }
}
