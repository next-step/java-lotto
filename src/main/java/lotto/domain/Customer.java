package lotto.domain;

import lotto.domain.generator.LottoGenerator;

import java.util.List;

public class Customer {
    private int purchaseAmount;
    private List<Lotto> lottos;

    public Customer(int purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
    }

    public void purchaseLottos() {
        lottos = LottoGenerator.generateLottosByAmount(purchaseAmount);
    }

    public double calculateROI() {
        double totalPrize = 0;

        for (Lotto lotto : lottos) {
            totalPrize += lotto.getPrize();
        }

        return totalPrize / purchaseAmount;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
