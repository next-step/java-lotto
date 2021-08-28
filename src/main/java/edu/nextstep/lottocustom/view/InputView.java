package edu.nextstep.lottocustom.view;

import edu.nextstep.lottocustom.exception.CustomException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);
    private static final String PAYMENT = "구입금액";
    private static final String BONUS_NUMBER = "보너스 볼";
    private static final String NUMBER_OF_CUSTOM_TICKETS = "수동으로 구매할 로또 수";

    public static int inputPayment() {
        return inputNumber(PAYMENT);
    }

    public static int inputBonusNumber() {
        return inputNumber(BONUS_NUMBER);
    }

    public static int inputNumberOfCustomTickets() {
        int numberOfCustomTickets = inputNumber(NUMBER_OF_CUSTOM_TICKETS);
        validatePositiveNumber(numberOfCustomTickets);
        return numberOfCustomTickets;
    }

    private static void validatePositiveNumber(int number) {
        if (number < 0) {
            throw new CustomException(NUMBER_OF_CUSTOM_TICKETS + "는 양의 정수만 입력 가능합니다.");
        }
    }

    private static int inputNumber(String inputName) {
        System.out.println(inputName + "을(를) 입력해 주세요.");
        String inputValue = scanner.nextLine();
        try {
            return Integer.parseInt(inputValue);
        } catch (NumberFormatException e) {
            System.out.println(inputName + " 은(는) 숫자만 입력 가능합니다.");
            System.exit(0);
            return 0;
        } finally {
            System.out.println();
        }
    }

    public static String inputWinningNumbers() {
        System.out.println(System.lineSeparator() + "지난 주 당첨 번호를 입력해 주세요.");
        return scanner.nextLine();
    }

    public static List<String> inputCustomNumbers(int numberOfCustomTickets) {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        List<String> customNumbersString = new ArrayList<>();
        for (int i = 0; i < numberOfCustomTickets; i++) {
            customNumbersString.add(scanner.nextLine());
        }
        System.out.println();
        return customNumbersString;
    }
}
