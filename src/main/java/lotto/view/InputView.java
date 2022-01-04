package lotto.view;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class InputView {

    private static final Scanner sc = new Scanner(System.in);

    private static final int LOTTO_PRICE = 1_000;

    public InputView() {
    }

    public static int inputPrice() {
        System.out.println("구입 금액을 입력해 주세요.");
        int price = sc.nextInt();
        checkPrice(price);
        int number = price / LOTTO_PRICE;
        System.out.println(number + "개를 구매했습니다.");
        sc.nextLine();
        return number;
    }


    public static Set<Integer> inputWinningNumber() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String[] numbers = sc.nextLine().split(",");
        Set<Integer> winningNumber = Arrays
            .stream(numbers).map(Integer::parseInt).collect(Collectors.toSet());
        return winningNumber;
    }

    public static int inputBonusBall() {
        System.out.println("보너스 볼을 입력해주세요.");
        return sc.nextInt();
    }

    private static void checkPrice(int price) {
        if (price < LOTTO_PRICE) {
            throw new IllegalStateException("구입 금액은 로또 1개의 가격보다 많아야 합니다.");
        }
    }

}
