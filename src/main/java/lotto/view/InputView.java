package lotto.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final String SEPARATOR = ",";
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final int PER_MONEY = 1000;

    public int inputMoneyPrint() {
        System.out.println("구입금액을 입력해 주세요.");

        int money = SCANNER.nextInt();
        SCANNER.nextLine();

        if(money < PER_MONEY) {
            throw new IllegalArgumentException("천원 이상의 금액을 입력해주세요.");
        }

        return money;
    }

    public List<Integer> inputLottoNumbers() {
        System.out.println("\n지난 주 당첨 번호를 입력해 주세요.");

        String inputNumber = SCANNER.nextLine();
        String[] inputNumberArray = inputNumber.split(SEPARATOR);

        return Arrays.stream(inputNumberArray)
                .mapToInt(str -> Integer.parseInt(str.trim()))
                .boxed()
                .collect(Collectors.toList());
    }

    public int inputLottoBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");

        int bonusNumber = SCANNER.nextInt();
        SCANNER.nextLine();

        return bonusNumber;
    }
}
