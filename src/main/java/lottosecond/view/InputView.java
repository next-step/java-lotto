package lottosecond.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {

    public int inputLottoBuyMoney() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("구입금액을 입력해 주세요.");
        return scanner.nextInt();
    }

    public String printWinningNumbers() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return scanner.nextLine();
    }

    public int inputBonusNumber() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("보너스 볼을 입력해 주세요.");
        return scanner.nextInt();
    }

    public int manualLottoCount() {
        Scanner scanner = new Scanner(System.in);
        System.out.println();
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        return scanner.nextInt();
    }

    public void printManualLottos() {
        System.out.println();
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
    }

    public List<String> inputManualLottoNumbers(int manualLottoCount) {
        Scanner scanner = new Scanner(System.in);
        List<String> lottoNumbers = new ArrayList<>();
        for (int i = 0; i < manualLottoCount; i++) {
            lottoNumbers.add(scanner.nextLine());
        }
        return lottoNumbers;
    }
}