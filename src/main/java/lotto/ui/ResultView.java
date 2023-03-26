package lotto.ui;

import lotto.LottoMemo;

public class ResultView {


//3개 일치 (5000원)- 1개 - 5등
//4개 일치 (50000원)- 0개 - 4등
//5개 일치 (1500000원)- 0개 - 3등
//5개 일치, 보너스 볼 일치(30000000원) - 0개 - 2등?
//6개 일치 (2000000000원)- 0개 - 1등?
    public static void method1(LottoMemo lottoMemo, double purchaseAmount){
        double result = lottoMemo.getResult() / purchaseAmount;
        System.out.println("3개 일치 (5000원)- " + lottoMemo.getFifth() + "개 - 5등");
        System.out.println("4개 일치 (50000원)- " + lottoMemo.getFourth() + "개 - 4등");
        System.out.println("5개 일치 (1500000원)- " + lottoMemo.getThird() + "개 - 3등");
        System.out.println("5개 일치, 보너스 볼 일치(30000000원)- " + lottoMemo.getSecond() + "개 - 2등");
        System.out.println("6개 일치 (2000000000원)- " + lottoMemo.getSecond() + "개 - 2등");
        System.out.println("총 수익률은 " + result + "입니다.");
    }
}
