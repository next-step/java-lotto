package lottoAuto.view;

import java.util.Scanner;

public class InputView {
    private Scanner scanner = new Scanner(System.in);

    public int inputPrice() {
        System.out.println("구입금액을 입력해 주세요.");
        int price = scanner.nextInt();
        return price;
    }

    public String inputWinningNumber() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String winningLottoString = scanner.next();

        return winningLottoString;
    }

    public int inputBonusBall() {
        System.out.println("보너스 볼을 입력해 주세요.");
        int bonusBall = scanner.nextInt();

        return bonusBall;
    }
}
