package view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Question {
    private Question() {
    }

    public static int intAsk(String question) {
        System.out.print(question + ": ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public static List<Integer> intListAsk(String question) {
        System.out.print(question + ": ");
        Scanner scanner = new Scanner(System.in);
        String multiNumberString =  scanner.nextLine();

        List<String> spllitedString = List.of(multiNumberString.split(","));

        List<Integer> integerList = new ArrayList<>();
        for (String stringToken : spllitedString) {
            integerList.add(Integer.parseInt(stringToken));
        }

        return integerList;
    }
}