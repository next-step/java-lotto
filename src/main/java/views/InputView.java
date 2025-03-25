package views;

import domain.Tokens;

import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    public static Tokens promptForTokens(String query) {
        return tokenize(inputExpression(query));
    }

    public static String inputExpression(String query) {
        System.out.println(query);
        return scanner.nextLine();
    }

    public static Tokens tokenize(String string) {
        return new Tokens(string);
    }
}
