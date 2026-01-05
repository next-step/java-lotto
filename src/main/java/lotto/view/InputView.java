package lotto.view;

import lotto.Lotto;
import lotto.LottoNumber;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {

    public static BigDecimal inputPurchaseAmount() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("구입금액을 입력해 주세요.");

        return scanner.nextBigDecimal();
    }

    public static Lotto inputWinningNumbers() {
        Scanner scanner = new Scanner(System.in);
        System.out.println();
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");

        String[] numberStrings = scanner.nextLine().split(",");
        List<Integer> numbers = new ArrayList<>();
        for (String numberString : numberStrings) {
            numbers.add(Integer.parseInt(numberString.trim()));
        }
        return new Lotto(numbers);
    }

    public static LottoNumber inputBonusNumber() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("보너스 볼을 입력해 주세요.");

        int bonusNumber = scanner.nextInt();
        return LottoNumber.valueOf(bonusNumber);
    }
}
