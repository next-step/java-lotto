package views;

import step1.Tokens;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    public static List<Integer> promptForIntegerList(String query, String delimiter) {
        Tokens tokens = promptForTokens(query, delimiter);
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < tokens.size(); i++ ) {
            result.add(Integer.parseInt(tokens.getToken(i)));
        }
        return result;
    }

    public static Tokens promptForTokens(String query, String delimiter) {
        return tokenize(inputExpression(query), delimiter);
    }

    public static Integer promptForInteger(String query) {
        return Integer.parseInt(inputExpression(query));
    }

    public static String inputExpression(String query) {
        System.out.println(query);
        return scanner.nextLine();
    }

    public static Tokens tokenize(String string, String delimiter) {
        return new Tokens(string, delimiter);
    }
}
