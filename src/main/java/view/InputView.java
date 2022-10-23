package view;

import java.util.Scanner;

import domain.BonusNumber;
import domain.Lotto;
import domain.Money;

public class InputView {

    private static final Scanner sc = new Scanner(System.in);

    public static Money inputPurchaseMoney() {

        System.out.println("구입금액을 입력해 주세요.");
        int purchaseMoney = sc.nextInt();
        sc.nextLine();
        return Money.from(purchaseMoney);
    }

    public static Lotto inputLastWeekWinnerNumber() {

        System.out.println("지난 주 당첨 번호를 입력해 주세요.");

        String winnerNumber = sc.nextLine();

        return Lotto.from(winnerNumber);
    }

    public static BonusNumber inputBonusNumber() {

        System.out.println("보너스 볼을 입력해 주세요.");

        String bonusNumber = sc.nextLine();

        return BonusNumber.from(bonusNumber);
    }


}
