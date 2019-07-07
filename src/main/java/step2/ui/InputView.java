package step2.ui;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import step2.dto.LottoDto;
import step2.dto.LottosDto;

public class InputView {

    public static long inputMoney() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("구입금액을 입력해 주세요.");
        return scanner.nextLong();
    }

    public static int inputCountOfUserPickLotto() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n수동으로 구매할 로또 수를 입력해 주세요.");
        return scanner.nextInt();
    }

    public static LottosDto inputLottoNumbers(final int userPickCount) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n수동으로 구매할 번호를 입력해 주세요.");
        List<LottoDto> lottoNumbers = new ArrayList<>();

        for (int i = 0; i < userPickCount; i++) {
            final String numbersLine = scanner.nextLine();
            LottoDto lotto = new LottoDto(Arrays.stream(numbersLine.split(", "))
                                                .map(Integer::parseInt)
                                                .collect(Collectors.toList()));
            lottoNumbers.add(i, lotto);
        }

        return new LottosDto(lottoNumbers);
    }

    public static LottoDto inputWinningLottoNumbers() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n지난 주 당첨 번호를 입력해 주세요.");
        final String numbersLine = scanner.nextLine();

        return new LottoDto(Arrays.stream(numbersLine.split(", "))
                                  .map(Integer::parseInt)
                                  .collect(Collectors.toList()));
    }

    public static int inputBonusNumber() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("보너스 볼을 입력해 주세요.");
        return scanner.nextInt();
    }
}
