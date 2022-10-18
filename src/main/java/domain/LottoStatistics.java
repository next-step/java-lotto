package domain;

import java.util.List;

public class LottoStatistics {
    private Price winningPrice;
    private Price purchasePrice;

    private long numberOfThreeEqualNumber;
    private long numberOfFourEqualNumber;
    private long numberOfFiveEqualNumber;
    private long numberOfSixEqualNumber;

    public LottoStatistics(Price purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public void analysis(List<Lotto> lottos, Lotto winningLotto) {
        this.numberOfThreeEqualNumber = countEqualNumber(LottoUnitWinnings.THREE.getEqualCount(), lottos, winningLotto);
        this.numberOfFourEqualNumber = countEqualNumber(LottoUnitWinnings.FOUR.getEqualCount(), lottos, winningLotto);
        this.numberOfFiveEqualNumber = countEqualNumber(LottoUnitWinnings.FIVE.getEqualCount(), lottos, winningLotto);
        this.numberOfSixEqualNumber = countEqualNumber(LottoUnitWinnings.SIX.getEqualCount(), lottos, winningLotto);

        calculateWinningPrice();
    }

    private long countEqualNumber(int numberOfEqualNumber, List<Lotto> lottos, Lotto winningLotto) {
        return lottos.stream()
                .filter(lotto -> winningLotto.countEqualNumber(lotto) == numberOfEqualNumber)
                .count();
    }

    private void calculateWinningPrice() {
        this.winningPrice = LottoWinningsCalculator.calculateWinnings(LottoUnitWinnings.THREE.getEqualCount(), numberOfThreeEqualNumber)
                .add(LottoWinningsCalculator.calculateWinnings(LottoUnitWinnings.FOUR.getEqualCount(), numberOfFourEqualNumber))
                .add(LottoWinningsCalculator.calculateWinnings(LottoUnitWinnings.FIVE.getEqualCount(), numberOfFiveEqualNumber))
                .add(LottoWinningsCalculator.calculateWinnings(LottoUnitWinnings.SIX.getEqualCount(), numberOfSixEqualNumber));
    }

    public Price getWinningPrice() {
        return this.winningPrice;
    }

    public double calculateEfficiency() {
        return winningPrice.divideWithDecimalPoint(purchasePrice);
    }

    public long getNumberOfThreeEqualNumber() {
        return numberOfThreeEqualNumber;
    }

    public long getNumberOfFourEqualNumber() {
        return numberOfFourEqualNumber;
    }

    public long getNumberOfFiveEqualNumber() {
        return numberOfFiveEqualNumber;
    }

    public long getNumberOfSixEqualNumber() {
        return numberOfSixEqualNumber;
    }
}
