package step2.view;

import step2.lib.PrintMessage;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 사용자의 입력을 받아 입력한 값을 반환해주는 작업을 처리하는 클래스
 */
public class InputScanner {

    private final static Scanner SCANNER = new Scanner(System.in);

    private InputScanner() {}

    /**
     * message를 받아 출력과 동시에 사용자 int 형 입력 값을 받는다.
     *
     * @param message
     * @return
     */
    public static int getInt(String message) {
        PrintMessage.println(message);
        return SCANNER.nextInt();
    }

    /**
     * message를 받아 출력과 동시에 사용자 int 형 입력 값을 받는다.
     *
     * @param message
     * @return
     */
    public static List<Integer> getInts(String message) {
        PrintMessage.print(message);
        return Arrays.stream(SCANNER.next().split(","))
                .map(value -> Integer.parseInt(value.trim()))
                .collect(Collectors.toList());
    }

    /**
     * message를 받아 출력과 동시에 사용자 int 형 List 입력 값을 받는다.
     *
     * @param message
     * @return
     */
    public static List<List<Integer>> getNumbersList(String message) {
        int countOfList = InputScanner.getInt(message);

        List<List<Integer>> numbers = new ArrayList<>();

        IntStream.rangeClosed(1, countOfList)
                .forEach((number) -> numbers.add(Arrays.asList()));

        return numbers;
    }
}
