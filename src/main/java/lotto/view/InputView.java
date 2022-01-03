package lotto.view;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class InputView {

    private static final Scanner sc = new Scanner(System.in);

    private static final int LOTTO_PRICE = 1000;

    public InputView() {
    }

    public static int inputPrice() {
        System.out.println("구입 금액을 입력해 주세요.");
        int price = sc.nextInt();
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


}
