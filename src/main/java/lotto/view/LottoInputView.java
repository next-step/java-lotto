package lotto.view;

import java.util.List;
import java.util.Scanner;

import static lotto.utils.StringParser.stringToIntegerList;

public class LottoInputView {
    private final Scanner scanner = new Scanner(System.in).useDelimiter("\n");

    public int inputBuyingMoney() {
        System.out.println("구매금액을 입력해주세요.");
        return scanner.nextInt();
    }

    public List<Integer> inputWinningNumbers() {
        System.out.println("당첨번호를 입력해주세요.");
        return stringToIntegerList(scanner.next());
    }

    public int inputBonusNumber() {
        System.out.println("보너스번호를 입력해주세요.");
        return scanner.nextInt();
    }

}
