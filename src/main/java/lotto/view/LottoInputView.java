package lotto.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LottoInputView {

    private static final Scanner scanner = new Scanner(System.in);

    public static String inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        return scanner.nextLine();
    }


    public static List<String> inputWinLotto() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String winLotto = scanner.nextLine();
        System.out.println();
        return Arrays.stream(winLotto.split(","))
                .map(String::trim)
                .collect(Collectors.toList());

    }
}
