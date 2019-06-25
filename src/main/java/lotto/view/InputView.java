package lotto.view;

import lotto.model.Order;
import lotto.model.WinningNumbers;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private static Scanner scanner = new Scanner(System.in);

    public static Order inputOrderAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        scanner = new Scanner(System.in);
        return new Order(scanner.nextInt());
    }


    public static List<Integer> inputWinningNumber() {
        System.out.println("당첨번호를 입력하세요.");
        scanner = new Scanner(System.in);
        return splitNumbers(scanner.nextLine());
    }

    public static List<Integer> inputHandPickNumber() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        scanner = new Scanner(System.in);
        return splitNumbers(scanner.nextLine());
    }

    public static int handPickCount() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        return scanner.nextInt();
    }


    public static int winningBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    private static List<Integer> splitNumbers(String stringNumbers) {
        return Arrays.stream(stringNumbers.split(","))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());
    }

}
