package lotto.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final String SEPARATOR = ",";
    private static final Scanner scanner = new Scanner(System.in);

    public int inputMoneyPrint() {
        System.out.println("구입금액을 입력해 주세요.");

        int money;
        try {
            money = scanner.nextInt();
            scanner.nextLine();
        } catch (Exception e) {
            throw new IllegalArgumentException("1,000원 이상의 금액을 입력해주세요.");
        }

        return money;
    }

    public List<Integer> inputLottoNumbers() {
        System.out.println("\n지난 주 당첨 번호를 입력해 주세요.");

        String inputNumber = scanner.nextLine();

        String[] inputNumberArray = inputNumber.split(SEPARATOR);

        return Arrays.stream(inputNumberArray)
                .mapToInt(str -> Integer.parseInt(str.trim()))
                .boxed()
                .collect(Collectors.toList());
    }
}
