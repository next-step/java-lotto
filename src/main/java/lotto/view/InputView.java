package lotto.view;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);
    private static final String WINNING_NUMBER_SPLIT_EXPRESSION = ",";

    private InputView(){}

    public static int inputPurchasePrice(){
        System.out.println("구입금액을 입력해 주세요.");
        return scanner.nextInt();
    }

    public static List<Integer> lastWeekLottoPrizeNumber() {
        System.out.println();
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String[] splitPrizeNumber = scanner.next().split(WINNING_NUMBER_SPLIT_EXPRESSION);
        return Stream.of(splitPrizeNumber)
                      .map(Integer::parseInt)
                      .collect(Collectors.toList());

    }
}
