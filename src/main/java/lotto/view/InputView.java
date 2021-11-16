package lotto.view;

import util.NumberUtils;

import java.util.*;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private final static Scanner scanner = new Scanner(System.in);

    private InputView() {}

    public static int getIntValue(String message){
        String input = getInput(message);
        if(!NumberUtils.isIntValue(input)) {
            throw new IllegalArgumentException("입력 값이 숫자가 아닙니다.");
        }
        return Integer.parseInt(input);
    }

    private static String getInput(String message) {
        System.out.println(message);
        return scanner.next();
    }

    public static List<Integer> getCommaSplitIntList(String message){
        String[] list = getInput(message).split(",");
        checkAllInt(list);
        return Arrays.stream(list)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private static void checkAllInt(String[] list) {
        boolean allInt = Arrays.stream(list).allMatch(NumberUtils::isIntValue);
        if(!allInt) {
            throw new IllegalArgumentException("입력 값이 숫자가 아닙니다.");
        }
    }
}