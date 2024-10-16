package lotto.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.locks.Lock;

import lotto.domain.BonusNumber;
import lotto.domain.LottoNumbers;
import lotto.domain.WinNumber;

public class InputView {

    public static final String DELIMITER = ", ";

    public static int inputAmount() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("구입금액을 입력해 주세요.");
        return scanner.nextInt();
    }

    public static WinNumber inputWinnerNumber() {
        Scanner scanner = new Scanner(System.in);
        System.out.println();
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String inputNumber = scanner.nextLine();

        String[] split = inputNumber.split(DELIMITER);

        return new WinNumber(split);
    }

    public static BonusNumber inputBonusNumber() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("보너스 볼을 입력해 주세요.");
        return new BonusNumber(scanner.nextInt());
    }

    public static int manualAmount() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        return scanner.nextInt();
    }

    public static List<LottoNumbers> inputManualNumbers(int manualAmount) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");

        List<LottoNumbers> lottoNumbers = new ArrayList<>();
        for(int i=0; i<manualAmount; i++) {
            lottoNumbers.add(new LottoNumbers(scanner.nextLine().split(DELIMITER)));
        }

        return lottoNumbers;
    }
}
