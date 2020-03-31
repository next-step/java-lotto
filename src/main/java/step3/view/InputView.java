package step3.view;

import step3.domain.LottoNumber;

import java.util.Scanner;

public class InputView {
    private Scanner scanner;

    public int askTotalPrice() {
        System.out.println("구입금액을 입력해 주세요");
        scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public String askWinnerLottoNumber() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public LottoNumber askBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        scanner = new Scanner(System.in);
        return new LottoNumber(scanner.nextInt());
    }
}
