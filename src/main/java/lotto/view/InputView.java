package lotto.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
        Scanner scanner = new Scanner(System.in);

    public int inputPayment() {
        System.out.println("구입 금액을 입력해주세요 :)");
        return Integer.parseInt(scanner.nextLine());
    }

    public List<Integer> inputWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해주세요 :)");
        return split(scanner.nextLine());
    }

    public List<Integer> split(String input) {
        List<String> strings = Arrays.asList(input.replaceAll(" ", "").split(","));
        return strings.stream().map(Integer::parseInt).collect(Collectors.toList());
    }
}
