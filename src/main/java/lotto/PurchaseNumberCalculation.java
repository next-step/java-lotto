package lotto;

public class PurchaseNumberCalculation {

    public static int calculateNumberPurchase(int purchaseAmount) {
        if (purchaseAmount < 1000) {
            throw new IllegalArgumentException("1000원 이상을 투입 해주세요");
        }

        if (purchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException("1000원 단위로 투입 해주세요");
        }

        return purchaseAmount / 1000;
    }
}
