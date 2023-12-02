package lotto.view;

import lotto.domain.WinningLotto;
import lotto.util.LottoUtil;

import java.util.Scanner;

public class InputView {

    public static int inputPayMoney(){
        System.out.println("구매금액을 입력해 주세요.");

        Scanner scanner = new Scanner(System.in);

        return scanner.nextInt();
    }

    public static WinningLotto inputWinningNumbers(){
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");

        Scanner scanner = new Scanner(System.in);
        String[] winningNumbers = LottoUtil.splitString(scanner.nextLine());
        System.out.println("보너스 볼을 입력해 주세요.");
        int bonusNumber = scanner.nextInt();

        return LottoUtil.settingWinnerNumber(winningNumbers, bonusNumber);
    }

}
