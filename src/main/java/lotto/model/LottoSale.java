package lotto.model;

public class LottoSale {

    public int sale(String purchaseAmount) {

        int purchaseCount = Integer.parseInt(purchaseAmount) / 1000;

        return purchaseCount;
    }


}
