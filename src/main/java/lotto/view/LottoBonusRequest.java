package lotto.view;

import lotto.domain.LottoPurchases;

import java.util.Scanner;

public class LottoBonusRequest {
    private final int bonusBall;

    public LottoBonusRequest(int bonusBall) {
        this.bonusBall = bonusBall;
    }

    public static LottoBonusRequest lottoBonusBall() {
        int inputBonusBall = bonusBallRequest();
        return new LottoBonusRequest(inputBonusBall);
    }

    private static int bonusBallRequest() {
        Scanner sc = new Scanner(System.in);
        System.out.println("보너스 볼을 입력해 주세요.");
        return sc.nextInt();
    }

    public int getBonusBall() {
        return bonusBall;
    }
}
