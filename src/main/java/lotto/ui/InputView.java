package lotto.ui;

import lotto.domain.LottoNo;
import lotto.utils.LottoCollectionUtils;

import java.util.List;
import java.util.Scanner;

public class InputView {

    private InputView() {

    }

    public static int inputPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public static List<LottoNo> inputWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);

        return LottoCollectionUtils.convert(scanner.nextLine().split(", "));
    }

    public static LottoNo inputBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);
        return LottoNo.create(scanner.nextInt());
    }
}
