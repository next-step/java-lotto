package lotto.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    public static int inputPurchasePrice(){
        System.out.println("구입금액을 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);
        String price = scanner.nextLine();
        return Integer.parseInt(price);
    }

    public static List<Integer> lastWeekAnswer(){
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] numbers = input.split(",");

        return Arrays.stream(numbers)
                .map(number -> Integer.parseInt(number.trim()))
                .collect(Collectors.toList());
    }

    public static int bonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);
        String price = scanner.nextLine();
        return Integer.parseInt(price);
    }
}
