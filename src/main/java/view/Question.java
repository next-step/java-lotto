package view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Question {

    private static final Scanner SCANNER = new Scanner(System.in);

    private Question() {
    }

    public static int intAsk(String question) {
        System.out.print(question + ": ");
        return SCANNER.nextInt();
    }

    public static List<Integer> intListAsk(String question) {
        System.out.print(question + ": ");
        String multiNumberString =  SCANNER.nextLine();

        List<String> spllitedString = List.of(multiNumberString.split(","));

        List<Integer> integers = new ArrayList<>();
        for (String stringToken : spllitedString) {
            integers.add(Integer.parseInt(stringToken));
        }

        return integers;
    }
}