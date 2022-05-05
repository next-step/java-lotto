package lotto.domain;

import java.util.List;

public class Customer {
    private int money;
    private Lottos lottos;

    public Customer(int money) {
        this.money = money;
        this.lottos = new Lottos();
    }

    public Customer(int money, Lotto lotto) {
        this.money = money;
        this.lottos = new Lottos(lotto);
    }

    public void buy(int price) {
        while (hasMoney()) {
            lottos.createLotto();
            this.money -= price;
        }
    }

    private boolean hasMoney() {
        return this.money > 0;
    }

    public boolean balanceCheck(int money) {
        return this.money == money;
    }

    public List<List<Integer>> compareTo(List<Integer> winningLottoNumbers) {
//        List<List<Integer>> result = new ArrayList<>();
//
//        for (Lotto lotto : lottos) {
//            result.add(lotto.contains(winningLottoNumbers));
//        }
        return null;
    }

    public Lottos findLottoList() {
        return lottos;
    }
}
