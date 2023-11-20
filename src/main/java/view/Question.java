package view;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Question {

    private static Scanner SCANNER = new Scanner(System.in);

    private Question() {
    }

    /**
     * 인풋스트림을 날려 버리고 아무것도 없는 상태로 깨끗하게 초기화합니다.
     */
    private static void clear() {
        SCANNER = new Scanner(System.in);
    }

    public static int intAsk(String question) {
        clear();
        System.out.print(question + ": ");

        try {
            return SCANNER.nextInt();
        }
        catch (InputMismatchException e) {
            throw new NumberFormatException("숫자 입력을 기대했으나 숫자 외의 다른 입력이 들어왔습니다.");
        }
    }

    public static List<Integer> intListAsk(String question) {
        clear();
        System.out.print(question + ": ");
        String multiNumberString =  SCANNER.nextLine();

        List<String> spllitedString = List.of(multiNumberString.split(","));

        List<Integer> integers = new ArrayList<>();
        for (String stringToken : spllitedString) {
            addIfNumber(stringToken, integers);
        }

        return integers;
    }

    private static void addIfNumber(String stringToken, List<Integer> integers) {
        try {
            integers.add(Integer.parseInt(stringToken));
        }
        catch (NumberFormatException e) {
            throw new NumberFormatException("숫자 입력을 기대했으나 숫자 외의 다른 입력이 들어왔습니다.");
        }
    }
}