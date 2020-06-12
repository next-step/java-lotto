package step2.view;

import step2.model.*;
import step2.util.LottoNumberSplitter;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    private InputView() {
    }

    public static MoneyAmount getPurchaseAmount() {
        System.out.println("구입 금액을 입력해 주세요.");
        int useAmount = Integer.parseInt(scanner.nextLine());

        return MoneyAmount.create(Money.valueOf(useAmount));
    }

    public static int getManualCount() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");

        return Integer.parseInt(scanner.nextLine());
    }

    public static ManualLottoNumbers getManualLottoNumber(int manualCount) {
        if (manualCount == 0) {
            return ManualLottoNumbers.empty();
        }

        System.out.println("수동으로 구매할 번호를 입력해 주세요.");

        return IntStream.range(0, manualCount)
                .mapToObj(i -> readManualLottoNumbers())
                .collect(collectingAndThen(toList(), ManualLottoNumbers::create));
    }

    public static List<LottoNumber> readManualLottoNumbers() {
        return LottoNumberSplitter.split(scanner.nextLine()).stream()
                .map(LottoNumber::valueOf)
                .collect(Collectors.toList());
    }

    public static Set<LottoNumber> getWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String winningNumber = scanner.nextLine();

        return LottoNumberSplitter.split(winningNumber).stream()
                .map(LottoNumber::valueOf)
                .collect(Collectors.toSet());
    }

    public static LottoNumber getBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        int bonusNumber = scanner.nextInt();

        return LottoNumber.valueOf(bonusNumber);
    }
}
