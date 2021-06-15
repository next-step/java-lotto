package lotto.view;

import lotto.domain.LottoPurchase;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    Scanner scanner = new Scanner(System.in);

    public void countLotto() {
        LottoPurchase lottoPurchase = new LottoPurchase(scanner.nextInt());
        System.out.println(lottoPurchase.buyLotto() + "개를 구매했습니다.");
    }

    public void lastWeekLottoNumder() {
        List<String> lastWeek = new ArrayList<>();
        int k = Integer.parseInt(scanner.nextLine());
        for(int i = 0; i < k; i++) { lastWeek.add(scanner.nextLine()); }


    }

}
