package lotto.view;

import lotto.model.LottoNumber;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LottoManualInputView {

    public int inputPrice() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("구입금액을 입력해 주세요.");
        return scanner.nextInt();
    }

    public int inputManualLottoQuantity() {
        Scanner scanner = new Scanner(System.in);

        System.out.println();
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        return scanner.nextInt();
    }

    public List<String> inputManualLottoNumbers(int manualQuantity) {
        Scanner scanner = new Scanner(System.in);

        List<String> manualNumbers = new ArrayList<>();

        System.out.println();
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        for (int i = 0; i < manualQuantity; i++) {
            manualNumbers.add(scanner.nextLine());
        }
        return manualNumbers;
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
