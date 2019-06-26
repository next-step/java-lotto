package step2.ui;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    public static long inputMoney() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("구입금액을 입력해 주세요.");
        return scanner.nextLong();
    }

    public static int inputCountOfBuyLottoTicket() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n수동으로 구매할 로또 수를 입력해 주세요.");
        return scanner.nextInt();
    }

    public static List<List<Integer>> inputLottoNumbers(final int countOfLottoTicket) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n수동으로 구매할 번호를 입력해 주세요.");
        List<List<Integer>> lottoNumbers = new ArrayList<>();

        for (int i = 0; i < countOfLottoTicket; i++) {
            final String numbersLine = scanner.nextLine();
            List<Integer> numbers = Arrays.stream(numbersLine.split(", "))
                                          .map(Integer::parseInt)
                                          .collect(Collectors.toList());
            lottoNumbers.add(i, numbers);
        }

        return lottoNumbers;
    }

    public static List<Integer> inputWinningLottoNumbers() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n지난 주 당첨 번호를 입력해 주세요.");
        final String numbersLine = scanner.nextLine();

        return Arrays.stream(numbersLine.split(", "))
                     .map(Integer::parseInt)
                     .collect(Collectors.toList());
    }

    public static int inputBonusNumber() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("보너스 볼을 입력해 주세요.");
        return scanner.nextInt();
    }
}
