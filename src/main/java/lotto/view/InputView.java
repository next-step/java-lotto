package lotto.view;

import lotto.dto.Money;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    public static void inputUserMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);
        Money.inputUserMoney(scanner.nextInt());
    }

    public static List<Integer> inputWinningLotto() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);
        return split(scanner.nextLine().split(","));
    }

    public static List<Integer> split(String[] inputValues) {
        if (Arrays.stream(inputValues).distinct().count() != inputValues.length) {
            throw new IllegalArgumentException();
        }

        List<Integer> values = new ArrayList<Integer>(inputValues.length);
        Arrays.stream(inputValues).forEach(value -> values.add(Integer.parseInt(value)));
        return values;
    }
}
