package lotto.view;

import lotto.domain.LottoPurchase;

import java.util.Scanner;

public class InputView {
    Scanner scanner = new Scanner(System.in);

    public void countLotto(){
        LottoPurchase lottoPurchase = new LottoPurchase(scanner.nextInt());
        System.out.println(lottoPurchase.buyLotto()+ "개를 구매했습니다.");
    }

}
