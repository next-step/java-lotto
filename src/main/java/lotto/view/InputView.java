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


    public static WinningNumbers inputWinningNumber() {
        System.out.println("당첨번호를 입력하세요.");
        Scanner scanner = new Scanner(System.in);
        String stringNumbers = scanner.nextLine();
        List<Integer> numbers = Arrays.stream(stringNumbers.split(","))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());
        return new WinningNumbers(numbers);

    }

}
