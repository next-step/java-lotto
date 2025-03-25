package lotto.domain;

import java.util.List;

public class Customer {
    private int purchaseAmount;
    private List<Lotto> lottos;

    public Customer(int purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
    }

    public void purchaseLottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public double calculateROI() {
        double totalPrize = 0;

        for (Lotto lotto : lottos) {
            totalPrize += lotto.getPrize();
        }

        return totalPrize / purchaseAmount;
    }
}
