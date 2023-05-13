package lotto.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    public static int inputCostOfLotto() {
        Scanner scanner = new Scanner(System.in);
        int costOfLotto = scanner.nextInt();
        return costOfLotto;
    }

    public static String inputWinningNumber() {
        Scanner scanner = new Scanner(System.in);
        String winningNumber = scanner.nextLine();
        return winningNumber;
    }

    public static int inputBonusNumber() {
        Scanner scanner = new Scanner(System.in);
        int bonusNumber = scanner.nextInt();
        return bonusNumber;
    }

    public static int inputNumberOfManualLottos() {
        Scanner scanner = new Scanner(System.in);
        int numberOfManualLottos = scanner.nextInt();
        return numberOfManualLottos;
    }

    public static List<String> inputManualLottos(int numberOfManualLottos) {
        Scanner scanner = new Scanner(System.in);
        List<String> manualLottos = new ArrayList<>();
        for(int i = 0; i < numberOfManualLottos; i++ ){
            String manualLotto = scanner.nextLine();
            manualLottos.add(manualLotto);
        }
        return manualLottos;
    }
}
