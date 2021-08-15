package lottery.view;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ManualLotteryConsoleInput {

    private static final String MANUAL_LOTTERY_QUANTITY_QUESTION = "\n수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String MANUAL_LOTTERY_NUMBERS_QUESTION = "\n수동으로 구매할 번호를 입력해 주세요.";

    private static final Scanner scanner = new Scanner(System.in);

    public static String askManualLotteryQuantity() {
        System.out.println(MANUAL_LOTTERY_QUANTITY_QUESTION);
        return scanner.nextLine();
    }

    public static List<String> askManualLotteryNumbers(IntStream quantityStream) {
        return quantityStream
                .peek(ManualLotteryConsoleInput::askQuestionIfFirst)
                .mapToObj(i -> scanner.nextLine())
                .collect(Collectors.toList());
    }

    public static void askQuestionIfFirst(int index) {
        if (index == 0) {
            System.out.println(MANUAL_LOTTERY_NUMBERS_QUESTION);
        }
    }
}
