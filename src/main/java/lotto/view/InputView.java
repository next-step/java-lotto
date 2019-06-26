package lotto.view;

import lotto.domain.WinningNumbers;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Created by wyparks2@gmail.com on 2019-06-25
 * Blog : http://wyparks2.github.io
 * Github : http://github.com/wyparks2
 */
public class InputView {
    private static final String FIRST_QUESTION_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String SECOND_QUESTION_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";

    private InputView() {
    }

    public static int firstQuestionAndReturnAnswer() {
        System.out.println(FIRST_QUESTION_MESSAGE);

        Scanner scanner = new Scanner(System.in);
        int money = scanner.nextInt();
        return money;
    }

    public static WinningNumbers secondQuestionAndReturnAnswer() {
        newLine();

        System.out.println(SECOND_QUESTION_MESSAGE);

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().replaceAll(" ", "");

        List<Integer> winningNumbers = Arrays.stream(input.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        return new WinningNumbers(winningNumbers);
    }

    private static void newLine() {
        System.out.println();
    }
}
