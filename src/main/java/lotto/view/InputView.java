package lotto.view;

import lotto.model.Lotto;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class InputView {
    private static Scanner scanner = new Scanner(System.in);

    public static int inputInteger(String question) {
        System.out.println(question);
        return Integer.parseInt(scanner.nextLine());
    }

    public static List<Integer> inputIntegers(String question) {
        System.out.println(question);
        return inputSimpleIntegers();
    }

    public static List<Lotto> inputLottos(String question, int countOfLotto) {
        System.out.println(question);

        return IntStream.range(0, countOfLotto)
            .mapToObj(i -> Lotto.from(inputSimpleIntegers()))
            .collect(Collectors.toList());
    }

    private static String removeWhitespace(String value) {
        return value.replaceAll("\\s+","");
    }

    private static List<String> split(String value) {
        return Arrays.asList(value.split(","));
    }

    private static List<Integer> toIntegers(List<String> strings) {
        return strings.stream().map(Integer::valueOf).collect(Collectors.toList());
    }

    private static List<Integer> inputSimpleIntegers() {
        return toIntegers(split(removeWhitespace(scanner.nextLine())));
    }
}
