package lotto.view;

import lotto.domain.Lotto;

import java.util.Scanner;

public class LottoInputView {

    public static int askBuyAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        
        Scanner scanner = new Scanner(System.in);
        int amount = scanner.nextInt();
        while (!Lotto.PRICE.isMultiple(amount)) {
            System.out.printf("%d원 단위로 입력해주세요.%n", Lotto.PRICE.amount());
            amount = scanner.nextInt();
        }
        return amount;
    }

    public static String askLastWinnerNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");

        Scanner scanner = new Scanner(System.in);
        String lottoNumbers = scanner.nextLine();
        while (lottoNumbers.isBlank()) {
            System.out.println("빈 값은 허용하지 않습니다.");
            lottoNumbers = scanner.nextLine();
        }
        return lottoNumbers;
    }
}
