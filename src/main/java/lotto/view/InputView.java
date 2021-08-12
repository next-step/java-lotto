package lotto.view;

import lotto.exception.InputError;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final int LOTTO_PRICE = 1000;
    private static final String SEPARATOR = ",";
    private static final String BLANK = " ";
    private static final String ENTER = "\n";

    private InputView() {
    }

    public static int buyLotto() {
        System.out.println("구매 금액을 입력해 주세요.");
        int count = Integer.parseInt(scanner.nextLine()) / LOTTO_PRICE;
        if (count < 0) {
            throw new InputError("로또를 구매할 수 없는 금액입니다.");
        }
        System.out.println(count + "개를 구매했습니다.");
        return count;
    }

    public static List<Integer> inputWinningNumber() {
        System.out.println(ENTER + "지난 주 당첨 번호를 입력해 주세요.");
        String[] input = scanner.nextLine().replace(BLANK, "").split(SEPARATOR);

        return Arrays.stream(input)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
