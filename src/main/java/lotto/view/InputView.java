package lotto.view;

import lotto.dto.LottoRequestDto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final int ONE = 1;

    public static LottoRequestDto inputParameters() {
        int price = inputPrice();
        int manualCount = inputManualCount();
        List<String> manualLottoStrings = inputManualLottoStrings(manualCount);

        return new LottoRequestDto(price, manualCount, manualLottoStrings);
    }

    private static int inputPrice() {
        System.out.println("구입 금액을 입력해 주세요.");
        return scanner.nextInt();
    }

    private static int inputManualCount() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        return scanner.nextInt();
    }

    private static List<String> inputManualLottoStrings(int manualCount) {
        if (manualCount < ONE) {
            return Collections.EMPTY_LIST;
        }

        System.out.println("수동으로 구매할 로또 번호를 입력해 주세요.");
        List<String> manualLottoStrings = new ArrayList<>();
        for (int i = 0; i < manualCount; i++) {
            manualLottoStrings.add(scanner.next());
        }
        return manualLottoStrings;
    }

    public static LottoRequestDto inputLottoNumbers() {
        return new LottoRequestDto(inputWinningNumber(), inputBonusNumber());
    }

    private static String inputWinningNumber() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return scanner.next();
    }
    private static int inputBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return scanner.nextInt();
    }
}
