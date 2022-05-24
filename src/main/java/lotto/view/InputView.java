package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static Scanner scanner = new Scanner(System.in);

    private InputView() {
    }

    public static int inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        return scanner.nextInt();
    }

    public static int inputManualSize() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        return scanner.nextInt();
    }

    public static List<Lotto> inputManualNumbers(int manualSize) {
        scanner.nextLine();
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < manualSize; i++) {
            List<Integer> lottoNumbers =
                    Arrays.asList(scanner.nextLine().split(", "))
                            .stream()
                            .map(Integer::valueOf)
                            .collect(Collectors.toList());

            lottos.add(Lotto.of(lottoNumbers));
        }
        return lottos;
    }

    public static List<Integer> inputWinningNumbers() {
        System.out.println("\n지난 주 당첨 번호를 입력해 주세요.");
        String[] winningNumberString = scanner.nextLine().split(", ");
        return Arrays.stream(winningNumberString)
                .map(Integer::valueOf)
                .collect(Collectors.toList());
    }

    public static Integer inputBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return scanner.nextInt();
    }


}
