package lotto.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class InputView {

    private static final Scanner sc = new Scanner(System.in);

    private static final int LOTTO_PRICE = 1000;
    private static final int LOTTO_NUMBER_SIZE = 6;

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
        checkWinningNumber(numbers, winningNumber);
        return winningNumber;
    }

    private static void checkWinningNumber(String[] numbers, Set<Integer> winningNumber) {
        if (!(numbers.length == LOTTO_NUMBER_SIZE)) {
            throw new IllegalStateException("로또 숫자는 여섯개 입니다.");
        }
        if (winningNumber.size() < LOTTO_NUMBER_SIZE) {
            throw new IllegalStateException("로또 숫자는 중복될 수 없습니다.");
        }
    }


}
