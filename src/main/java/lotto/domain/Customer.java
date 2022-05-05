package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private int money;
    private final List<Lotto> lottos = new ArrayList<>();

    public Customer(int money) {
        this.money = money;
    }

    public Customer(int money, Lotto lotto) {
        this(money);
        lottos.add(lotto);
    }

    public List<Lotto> buy(int price) {

        while (this.money > 0) {
            Lotto lotto = new Lotto();
            this.money -= price;
            lottos.add(lotto);
        }

        return lottos;
    }


    public boolean balanceCheck(int money) {
        return this.money == money;
    }

    public List<List<Integer>> compareTo(List<Integer> prevLottoNumbers) {
        List<List<Integer>> result = new ArrayList<>();

        for (Lotto lotto : lottos) {
            result.add(lotto.contains(prevLottoNumbers));
        }
        return result;
    }
}
