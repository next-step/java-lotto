package lotto.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final String INPUT_MESSAGE_OF_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String INPUT_MESSAGE_OF_WINNING_NUMBER = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String SEPARATOR = ", ";
    private static final Scanner scanner = new Scanner(System.in);

    public static int inputPurchaseAmount(){
        System.out.println(INPUT_MESSAGE_OF_PURCHASE_AMOUNT);
        return Integer.parseInt(scanner.nextLine());
    }

    public static List<Integer> inputWinningNumbers(){
        System.out.println(INPUT_MESSAGE_OF_WINNING_NUMBER);
        String numbers = scanner.nextLine();
        return getWinningNumbers(numbers);
    }

    private static List<Integer> getWinningNumbers(String numbers){
        return Arrays.asList(numbers.split(SEPARATOR))
                .stream().mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());
    }
}
