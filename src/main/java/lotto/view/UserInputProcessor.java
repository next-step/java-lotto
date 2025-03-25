package lotto.view;

import lotto.UserInput;

import java.util.Scanner;

public class UserInputProcessor {
    private static final Scanner scanner = new Scanner(System.in);

    public static UserInput getInput() {
        System.out.println("구입금액을 입력해 주세요.");
        return UserInput.from(scanner.nextLine());
    }
}
