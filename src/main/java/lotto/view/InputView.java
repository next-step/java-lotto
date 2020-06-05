package lotto.view;

import lotto.domain.dto.ManualNumberDto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);

    private InputView() {
    }

    public static int inputPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");

        try {
            return Integer.parseInt(SCANNER.nextLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력해 주세요.");
        }
    }

    public static int inputNumberOfManualTicket() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");

        try {
            return Integer.parseInt(SCANNER.nextLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력해 주세요.");
        }
    }

    public static List<ManualNumberDto> inputManualNumber(int numberOfManualTicket) {
        if (numberOfManualTicket < 1) {
            return Collections.emptyList();
        }

        System.out.println("수동으로 구매할 번호를 입력해 주세요.");

        List<ManualNumberDto> manualNumbersDtos = new ArrayList<>();

        for (int i = 0; i < numberOfManualTicket; i++) {
            manualNumbersDtos.add(new ManualNumberDto(SCANNER.nextLine()));
        }

        return manualNumbersDtos;
    }

    public static ManualNumberDto inputLastWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");

        return new ManualNumberDto(SCANNER.nextLine());
    }

    public static int inputBonusNumber() {
        System.out.println("보너스 볼을 입력해주세요.");

        String stringBonusNumber = SCANNER.nextLine();

        return Integer.parseInt(stringBonusNumber);
    }
}
