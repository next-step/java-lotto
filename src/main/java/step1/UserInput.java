package step1;

import java.util.Scanner;

public class UserInput {

    private static final Scanner SCANNER = new Scanner(System.in);

    private UserInput() {
    }

    public static Word word() {
        return new Word(SCANNER.nextLine());
    }

}
