package autolotto;

import java.util.ArrayList;
import java.util.List;

public class Wallet {
    private final int money;
    private final List<Lotto> lottoList;

    public Wallet(int money) {
        this(money, new ArrayList<>());
    }

    public Wallet(int money, List<Lotto> lottoList) {
        this.money = money;
        this.lottoList = lottoList;
    }

    public void addLotto(Lotto lotto) {
        this.lottoList.add(lotto);
    }

    public int lottoSize() {
        return this.lottoList.size();
    }

}
