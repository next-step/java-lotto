package step2.domain;

public class Return {

    private final double purchasePrice;
    private double amountOfReturn = 0;

    public Return(int purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public void plusResult(LottoResult result, int numberOfMatched) {
        amountOfReturn += result.winningPrice * numberOfMatched;
    }

    public double getRateOfReturn() {
        return (amountOfReturn / purchasePrice);
    }

}