package lotto.ui;

import lotto.domain.Lotto;
import lotto.domain.WinningLotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static java.util.stream.Collectors.toList;

public class InputView {
    public static final String NUMBER_DELIMITER = ",";
    private static final Scanner scanner = new Scanner(System.in);

    public static int getPrice() {
        System.out.println("구매금액을 입력해 주세요.");
        int price = scanner.nextInt();

        flushBuffer();

        return price;
    }

    public static WinningLotto getWinningLotto() {
        return new WinningLotto(createLotto(getWinningNumbers()), getBonusNumber());
    }

    private static String getWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return scanner.nextLine();
    }

    private static int getBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return scanner.nextInt();
    }

    public static int getManualPurchaseCount() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        return scanner.nextInt();
    }

    public static List<Lotto> getManualLottoNumbers(int manualPurchaseCount) {
        flushBuffer();
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        List<Lotto> lottos = new ArrayList<>();

        while (manualPurchaseCount != 0) {
            String value = scanner.nextLine();
            lottos.add(createLotto(value));

            manualPurchaseCount -= 1;
        }

        return lottos;
    }

    private static Lotto createLotto(String value) {
        return new Lotto(Arrays.stream(value.split(NUMBER_DELIMITER))
                .map(String::trim)
                .map(Integer::new)
                .collect(toList()));
    }

    private static void flushBuffer() {
        scanner.nextLine();
    }
}
