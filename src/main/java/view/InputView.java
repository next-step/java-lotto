package view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import domain.Lotto;
import domain.WinningNumbers;

import static utils.Splitter.splitAndConvertInt;

public class InputView {
    final static Scanner scanner = new Scanner(System.in);

    public static String inputWinningNumber() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return scanner.nextLine();
    }

    public static int inputAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return scanner.nextInt();
    }

    public static int inputBonusNumbers() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return scanner.nextInt();
    }

    public static int inputManualLottoCount() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        return scanner.nextInt();
    }

    public static List<Lotto> inputManualLottoNumber(int manualCount) {
        List<Lotto> result = new ArrayList<>();
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");

        scanner.nextLine();

        for(int i = 0 ; i< manualCount; i++){
            result.add(new Lotto(splitAndConvertInt(scanner.nextLine())));
        }

        return result;
    }
}
