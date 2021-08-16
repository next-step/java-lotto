package lotto.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private final Scanner scanner = new Scanner(System.in);

    public int inputPrice() {
        System.out.println("구입금액을 입력해 주세요.");
        return Integer.parseInt(scanner.nextLine());
    }

    public List<Integer> inputLastWinningNumber() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String numberString =  scanner.nextLine();
        return parseToIntegerList(splitString(numberString));
    }

    private List<String> splitString(String numberString) {
        List<String> splitNumbers = Arrays.asList(numberString.split(","));
        return splitNumbers;
    }

    private List<Integer> parseToIntegerList(List<String> stringList) {
        List<Integer> numbers = new ArrayList<>();
        for (String number : stringList) {
            numbers.add(Integer.parseInt(number.trim()));
        }
        return numbers;
    }
}
