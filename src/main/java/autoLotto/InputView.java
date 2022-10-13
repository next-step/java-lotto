package autoLotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static java.util.Arrays.*;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);

    public int inputAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        int amount = SCANNER.nextInt();

        System.out.println(amount + "개를 구매했습니다.");
        return amount;
    }

    public List<Integer> inputNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");

        List<Integer> numbers = new ArrayList<>();
        stream(SCANNER.next().split(", "))
                .map(i -> numbers.add(Integer.parseInt(i)));

        return numbers;
    }
}
