package lotto.view;

import lotto.domain.LottoNumber;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    public static final String NUMBER_DELIMITER = ", ";

    private InputView() {
    }

    public static int requestPurchaseAmount() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("구입금액을 입력해 주세요.");
        return scanner.nextInt();
    }

    public static List<LottoNumber> requestLastWinNumbers() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");

        String input = scanner.nextLine();
        return Arrays.stream(input.split(NUMBER_DELIMITER))
                .map(LottoNumber::of)
                .collect(Collectors.toList());
    }

    public static String requestBonusNumber() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("보너스 볼을 입력해 주세요.");
        return scanner.nextLine();
    }
}
