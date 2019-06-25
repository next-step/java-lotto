package lotto.view;

import lotto.model.Order;
import lotto.model.WinningNumbers;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {


    public static Order inputOrderAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);
        return new Order(scanner.nextInt());
    }


    public static List<Integer> inputWinningNumber() {
        System.out.println("당첨번호를 입력하세요.");
        Scanner scanner = new Scanner(System.in);
        String stringNumbers = scanner.nextLine();
        return Arrays.stream(stringNumbers.split(","))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());
    }

    public static int winningBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

}
