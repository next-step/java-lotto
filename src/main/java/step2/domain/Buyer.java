package step2.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Buyer {

    private final int LOTTO_PRICE = 1000;

    private List<Lotto> lottoList = new ArrayList<>();
    private int money;

    private Buyer(int money) {
        int buyCount = money / 1000;

        for (int i = 0; i < buyCount; i++) {
            addLotto();
        }

        this.money = money;
    }

    public static Buyer from(int money) {
        return new Buyer(money);
    }

    public int getMoney() {
        return money;
    }

    public int getLottoCounts() {
        return lottoList.size();
    }

    private void addLotto() {
        // TODO: 로또생성 하여 주입하는 로직 나중에 구현.
        List<Integer> temp = Arrays.asList(1, 2, 3, 4, 5, 6);
        this.lottoList.add(Lotto.from(temp));
    }
}
