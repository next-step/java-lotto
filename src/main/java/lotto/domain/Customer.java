package lotto.domain;

import lotto.domain.generator.LottoGenerator;

import java.util.List;

public class Customer {
    private int purchaseAmount;
    private Lottos lottos;

    public Customer() {
    }

    public Customer(int purchaseAmount, Lottos lottos) {
        this.purchaseAmount = purchaseAmount;
        this.lottos = lottos;
    }

    public void purchaseLottos(int purchaseAmount) {
        if (purchaseAmount <= 0) {
            throw new IllegalArgumentException("구입금액은 0 이하일 수 없습니다. 입력한 구입금액: " + purchaseAmount);
        }

        this.purchaseAmount = purchaseAmount;
        this.lottos = LottoGenerator.generateLottosByAmount(purchaseAmount);
    }

    public void checkLottosResult(List<LottoNumber> winningNumbers) {
        lottos.determineAllLottoResult(winningNumbers);
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
