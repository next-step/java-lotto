package Lotto.view;

import Lotto.domain.Purchase;

import java.util.Scanner;

import static Lotto.domain.Purchase.isInvalidPrice;

public class InputView {
    private static Scanner scanner = new Scanner(System.in);
    public static int askHowMuchYouWouldBuy() {
        System.out.println("구입금액을 입력해 주세요.");
        String price = scanner.nextLine();
        while(isInvalidPrice(price)) {
            System.out.println("구입은 1000원부터 가능합니다. 금액은 1000원 단위로 입력해 주세요.");
            price = scanner.nextLine();
        }
        return new Purchase(Integer.parseInt(price)).getQuantity();
    };
}
