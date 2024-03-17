package view;

import java.util.List;
import java.util.Scanner;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String WINNING_NUMBER_SEPARATOR = ",";

    public int inputPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return SCANNER.nextInt();
    }

    public List<String> inputWinningLottoNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return List.of(SCANNER.nextLine().split(WINNING_NUMBER_SEPARATOR));
    }
}
