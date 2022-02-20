package lotto.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import lotto.domain.LottoNumber;
import lotto.domain.WinningLotto;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);

    public static String inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        return SCANNER.nextLine();
    }

    public static List<String> inputLastWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return Arrays.stream(SCANNER.nextLine().split(","))
            .collect(Collectors.toList());
    }

    public static void inputBonusNumber(WinningLotto winningLotto) {
        try {
            System.out.println("보너스 볼을 입력해주세요.");
            LottoNumber bonusNumber = new LottoNumber(SCANNER.nextLine());
            winningLotto.setBonusNumber(bonusNumber);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            inputBonusNumber(winningLotto);
        }
    }
}
