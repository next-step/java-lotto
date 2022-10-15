package autoLotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import static java.util.Arrays.*;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);

    public int inputAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        int amount = SCANNER.nextInt();

        return amount;
    }

    public void inputNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");

        int inputNum = SCANNER.nextInt();

        System.out.println(inputNum);
//        List<Integer> numbers = Arrays.stream(inputNum.split(", "))
//                .map(Integer :: parseInt).collect(Collectors.toList());

    }
}
