package lotto.view;

import lotto.domain.LottoPurchases;

import java.util.Scanner;

public class LottoPurchaseRequest {

    private final int lottoPrice;
    private final int passivityPurchasesCount;

    public LottoPurchaseRequest(int lottoPrice, int passivityPurchasesCount) {
        this.lottoPrice = lottoPrice;
        this.passivityPurchasesCount = passivityPurchasesCount;
    }

    public static LottoPurchaseRequest inputLottoPrice() {
        int lottoPrice = lottoBuyPrice();
        int passivityPurchases = passivityPurchases();
        return new LottoPurchaseRequest(lottoPrice, passivityPurchases);
    }

    private static int lottoBuyPrice() {
        Scanner sc = new Scanner(System.in);
        System.out.println("구매금액을 입력해 주세요.");
        return sc.nextInt();
    }

    private static int passivityPurchases() {
        Scanner sc = new Scanner(System.in);
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        return sc.nextInt();
    }

    public int getLottoPriceCount() {
        return lottoPrice;
    }

    public int getPassivityPurchasesCount() {
        return passivityPurchasesCount;
    }
}
