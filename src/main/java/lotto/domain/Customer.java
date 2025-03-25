package lotto.domain;

import lotto.domain.generator.LottoGenerator;

public class Customer {
    private final int purchaseAmount;
    private Lottos lottos;

    public Customer(int purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
    }

    public Customer(int purchaseAmount, Lottos lottos) {
        this.purchaseAmount = purchaseAmount;
        this.lottos = lottos;
    }

    public void purchaseLottos() {
        if(purchaseAmount <= 0) {
            throw new IllegalArgumentException("구입금액은 0 이하일 수 없습니다. 입력한 구입금액: " + purchaseAmount);
        }

        lottos = LottoGenerator.generateLottosByAmount(purchaseAmount);
    }

    public double calculateROI() {
        double totalPrize = 0;

        for (Lotto lotto : lottos.getLottoList()) {
            totalPrize += lotto.getPrize();
        }

        return totalPrize / purchaseAmount;
    }

    public Lottos getLottos() {
        return lottos;
    }
}
