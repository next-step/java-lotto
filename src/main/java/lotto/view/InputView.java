package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.ManualLotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String DELIMITER = ", ";

    public static int getPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return Integer.parseInt(scanner.nextLine());
    }

    public static int getManualLottoCount() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        return Integer.parseInt(scanner.nextLine());
    }

    public static List<Lotto> getManualLottoList(int manualLottoCount) {
        List<Lotto> manualLottoList = new ArrayList<>();
        for (int i = 0; i < manualLottoCount; i++) {
            manualLottoList.add(getManualLotto());
        }

        return manualLottoList;
    }

    public static Lotto getWinningNumbers() {
        System.out.println("\n지난 주 당첨 번호를 입력해 주세요.");
        return getManualLotto();
    }

    public static LottoNumber getBonusNumber() {
        System.out.println("\n보너스 볼을 입력해 주세요.");
        return LottoNumber.of(Integer.parseInt(scanner.nextLine()));
    }

    private static Lotto getManualLotto() {
        return new ManualLotto(Arrays.stream(scanner.nextLine().split(DELIMITER))
                .map(Integer::parseInt)
                .map(LottoNumber::of)
                .collect(Collectors.toList()));
    }
}
