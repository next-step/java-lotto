package lotto.view;

import lotto.domain.LottoPurchases;

import java.util.Scanner;

public class LottoPurchaseRequest {

    private final int lottoPriceCount;

    public LottoPurchaseRequest(int lottoPriceCount) {
        this.lottoPriceCount = lottoPriceCount;
    }

    public static LottoPurchaseRequest inputLottoPrice() {
        int lottoPrice = lottoBuyPrice();
        return new LottoPurchaseRequest(lottoPrice);
    }

    private static int lottoBuyPrice() {
        Scanner sc = new Scanner(System.in);
        System.out.println("구매금액을 입력해 주세요.");
        return sc.nextInt();
    }

    public int getLottoPriceCount() {
        return lottoPriceCount;
    }
}
