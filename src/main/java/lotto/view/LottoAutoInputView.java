package lotto.view;

import lotto.model.LottoNumber;

import java.util.Scanner;

public class LottoAutoInputView {

    public int inputPrice() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("구입금액을 입력해 주세요.");
        return scanner.nextInt();
    }

    public String inputWinningNumbers() {
        Scanner scanner = new Scanner(System.in);

        System.out.println();
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return scanner.nextLine();
    }

    public int inputBonusNumber() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("보너스 볼을 입력해 주세요.");
        return scanner.nextInt();
    }
}
