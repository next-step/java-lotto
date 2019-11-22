package com.lotto.model;

import java.util.ArrayList;
import java.util.List;

public class UserLottos {

    public static final String DELIMITER_STRING = "/";

    private final Money money;

    private List<Lotto> lottos = new ArrayList<>();

    public UserLottos(Money money) {
        this.money = money;
        purchaseLotto();
    }

    private void purchaseLotto() {
        int numberOfLotto = this.money.numberOfLottoPurchased();
        for (int i = 0; i < numberOfLotto; i++) {
            Lotto lotto = new Lotto();
            lottos.add(lotto);
        }
    }

    public int size() {
        return lottos.size();
    }

    public String printUserLottos() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Lotto lotto : lottos) {
            stringBuilder.append(printLotto(lotto))
                         .append(DELIMITER_STRING);
        }
        return stringBuilder.toString();
    }

    private String printLotto(Lotto lotto) {
        return lotto.printNumbers();
    }

    public void match(WinningLotto winningLotto) {
        for (Lotto lotto : lottos) {
            lotto.match(winningLotto);
        }
    }

    public int getCountOf(int matchCount) {
        return (int) lottos.stream()
                .filter(lotto -> lotto.isMatchCount(matchCount))
                .count();
    }

    public Double getRate(int money) {
        final double winningMoney = lottos.stream()
                                          .mapToDouble(Lotto::isWinningMoney)
                                          .sum();
        return Math.floor(winningMoney / money * 100) / 100.0;
    }
}
