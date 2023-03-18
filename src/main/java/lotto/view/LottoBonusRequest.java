package lotto.view;

import lotto.domain.LottoNumber;
import lotto.domain.LottoPurchases;

import java.util.Scanner;

public class LottoBonusRequest {
    private final LottoNumber bonusBall;

    public LottoBonusRequest(LottoNumber bonusBall) {
        this.bonusBall = bonusBall;
    }

    public static LottoBonusRequest lottoBonusBall() {
        LottoNumber inputBonusBall = bonusBallRequest();
        return new LottoBonusRequest(inputBonusBall);
    }

    private static LottoNumber bonusBallRequest() {
        Scanner sc = new Scanner(System.in);
        System.out.println("보너스 볼을 입력해 주세요.");
        return new LottoNumber(sc.nextInt());
    }

    public LottoNumber getBonusBall() {
        return bonusBall;
    }
}
