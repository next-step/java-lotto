package lotto.view;

import lotto.domain.LottoNumber;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String SEPARATOR = ",";
    private static final String BLANK = " ";
    private static final String ENTER = "\n";

    private InputView() {
    }

    public static int inputPurchasePrice() {
        System.out.println("구매 금액을 입력해 주세요.");
        return Integer.parseInt(scanner.nextLine());
    }

    public static List<LottoNumber> inputWinningNumber() {
        System.out.println(ENTER + "지난 주 당첨 번호를 입력해 주세요.");
        String[] input = scanner.nextLine().replace(BLANK, "").split(SEPARATOR);

        return Arrays.stream(input)
                .map(LottoNumber::of)
                .collect(Collectors.toList());
    }

    public static int inputBonusBallNumber() {
        System.out.println("보너스 볼을 입력해주세요.");
        return scanner.nextInt();
    }
}
