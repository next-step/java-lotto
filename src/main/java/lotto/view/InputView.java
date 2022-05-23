package lotto.view;

import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    public static final int LOTTO_UNIT_NUMBER = 6;
    private static Scanner scanner = new Scanner(System.in);

    private InputView() {
    }

    public static int inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        return scanner.nextInt();
    }

    /*
    수동으로 구매할 로또 수를 입력해 주세요.
    3

    수동으로 구매할 번호를 입력해 주세요.
     */

    public static int inputManualSize() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        return scanner.nextInt();
    }

    public static List<Lotto> inputManualNumbers(int manualSize) {
        scanner.nextLine();
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < manualSize; i++) {
            List<String> lottoNumberString = Arrays.asList(scanner.nextLine().split(", "));
            List<Integer> lottoNumber = new ArrayList<>();
            lottoNumberString.forEach(number -> {
                lottoNumber.add(Integer.parseInt(number));
            });
            lottos.add(new Lotto(lottoNumber));
        }
        return lottos;
    }

    public static List<Integer> inputWinningNumbers() {
        System.out.println("\n지난 주 당첨 번호를 입력해 주세요.");
        String[] winningNumberString = scanner.nextLine().split(", ");
        Integer[] winningNumber = new Integer[LOTTO_UNIT_NUMBER];

        for (int i = 0; i < LOTTO_UNIT_NUMBER; i++) {
            winningNumber[i] = Integer.parseInt(winningNumberString[i]);
        }

        return Arrays.asList(winningNumber);
    }

    public static Integer inputBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return scanner.nextInt();
    }


}
