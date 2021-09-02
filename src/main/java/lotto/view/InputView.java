package lotto.view;

import static lotto.util.LottoStringUtil.splitStringToIntegerList;

import java.util.List;
import java.util.Scanner;

public class InputView {

    private final Scanner scanner = new Scanner(System.in);

    public int inputPrice() {
        System.out.println("구입금액을 입력해 주세요.");
        return Integer.parseInt(scanner.nextLine());
    }

    public List<Integer> inputLastWinningNumber() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String numberString = scanner.nextLine();
        return splitStringToIntegerList(numberString);
    }

    public int inputBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return scanner.nextInt();
    }

}
