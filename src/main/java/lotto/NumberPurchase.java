package lotto;

public class NumberPurchase {

    public static int calculateNumberPurchase(int purchase) {
        if (purchase < 1000) {
            throw new IllegalArgumentException("1000원 이상을 투입 해주세요");
        }

        if (purchase % 1000 != 0) {
            throw new IllegalArgumentException("1000원 단위로 투입 해주세요");
        }

        return purchase / 1000;
    }
}
