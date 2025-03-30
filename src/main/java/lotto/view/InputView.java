package lotto.view;

import lotto.view.model.UserMoneyInput;
import lotto.domain.model.WinningLotto;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InputView {
    private static final String DEFAULT_DELIMITER = ",";
    private static final Scanner scanner = new Scanner(System.in);

    public static UserMoneyInput getMoneyInput() {
        System.out.println("구입금액을 입력해 주세요.");
        return UserMoneyInput.from(scanner.nextLine());
    }

    public static WinningLotto getWinnerInput() {
        System.out.println("\n지난 주 당첨 번호를 입력해 주세요.");
        List<Integer> winningNumbers = convertStringToInt(scanner.nextLine());

        System.out.println("보너스 볼을 입력해 주세요.");
        int bonusNumber = scanner.nextInt();

        return WinningLotto.of(winningNumbers, bonusNumber);
    }

    private static List<Integer> convertStringToInt(String input) {
        String[] splitInput = split(input);
        return Stream.of(splitInput)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private static String[] split(String input) {
        return input.split(DEFAULT_DELIMITER);
    }


}
