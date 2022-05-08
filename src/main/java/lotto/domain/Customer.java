package lotto.domain;

import java.util.List;

public class Customer {
    private double money;
    private double totalAmount;
    private Lottos lottos;

    public Customer(int money) {
        this.money = money;
        this.totalAmount = money;
        this.lottos = new Lottos();
    }

    public Customer(int money, Lotto lotto) {
        this.totalAmount = 14000;
        this.money = 0;
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

    public void printLottoList() {
        lottos.printLottoList();
    }

    public List<Rank> getWinningList(List<Integer> winningNumbers) {
        return lottos.getWinningList(winningNumbers);
    }

    private void sumMoney(int money) {
        this.money += money;
    }

    public double profit(List<Rank> winningList) {
        winningList.stream()
                .forEach(rank -> sumMoney(rank.getMoney()));

        return Math.floor((money / totalAmount) * 100) / 100.0;
    }
}
