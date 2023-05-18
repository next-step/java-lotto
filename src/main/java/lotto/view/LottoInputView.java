package lotto.view;

import lotto.domain.Lotto;

import java.util.Scanner;

public class LottoInputView {

    public static int askBuyAmount() {
        System.out.println("구입금액을 입력해 주세요.");

        Scanner scanner = new Scanner(System.in);
        while (true) {
            int amount = scanner.nextInt();
            if (Lotto.PRICE.isMultiple(amount)) {
                return amount;
            }
            System.out.printf("%d원 단위로 입력해주세요.%n", Lotto.PRICE.amount());
        }
    }

    public static String askLastWinnerNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");

        Scanner scanner = new Scanner(System.in);
        while (true) {
            String lottoNumbers = scanner.nextLine();
            if (!lottoNumbers.isBlank()) {
                return lottoNumbers;
            }
            System.out.println("빈 값은 허용하지 않습니다.");
        }
    }
}
