package lotto;

import lotto.domain.LottoBuy;
import lotto.view.InputView;

import java.util.Scanner;

public class LottoApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("구입금액을 입력해 주세요.");
        int purchasePrice = Integer.parseInt(scanner.nextLine());

        LottoBuy lottoBuy = new LottoBuy(purchasePrice);

        System.out.println(lottoBuy);

    }
}
