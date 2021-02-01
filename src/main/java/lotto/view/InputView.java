package lotto.view;

import lotto.utils.InputValidator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static String input;

    public static int inputPrice() {
        boolean isValidPrice = false;
        while(!isValidPrice){
            System.out.println("구입금액을 입력해 주세요.");
            input = scanner.nextLine();
            isValidPrice = InputValidator.validatePrice(input);
        }
        return Integer.parseInt(input);
    }

    public static List<Integer> inputWinningNumbers() {
        boolean isValidPrice = false;
        while(!isValidPrice){
            System.out.println("지난 주 당첨 번호를 입력해 주세요.");
            input = scanner.nextLine();
            isValidPrice = InputValidator.validateWinningNumber(input);
        }
        List<Integer> winningNumbers = Arrays.stream(input.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        return winningNumbers;
    }

    public static int inputBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        String input = scanner.next();
        InputValidator.checkLottoNumberValidation(input);
        return Integer.parseInt(input);
    }
}
