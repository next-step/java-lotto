package lotto.view;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    private InputView() {
    }

    public static long requestPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");

        try {
            return scanner.nextLong();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자만 입력이 가능합니다.");
        }
    }

    public static int requestManualLottoCount() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");

        try {
            return scanner.nextInt();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자만 입력이 가능합니다.");
        }
    }

    public static List<String> requestManualLottoNumber(int manualLottoCount) {
        List<String> lottoNumbers = new ArrayList<>();

        if (manualLottoCount <= 0) {
            return lottoNumbers;
        }

        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        scanner.nextLine();

        for (int i = 0; i < manualLottoCount; i++) {
            lottoNumbers.add(scanner.nextLine());
        }

        return lottoNumbers;
    }

    public static String requestWinningNumber() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");

        return scanner.nextLine();
    }

    public static int requestBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");

        try {
            return scanner.nextInt();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자만 입력이 가능합니다.");
        }
    }
}
