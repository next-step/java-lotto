package lotto.ui;

import lotto.domain.LottoNumber;
import lotto.domain.WinningLottoTicket;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    public static Scanner SCANNER = new Scanner(System.in);

    public static int inputLottoPrice() {
        System.out.println("구입금액을 입력해 주세요.");
        return SCANNER.nextInt();
    }

    public static WinningLottoTicket inputWinningLottoNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String test = SCANNER.nextLine();
        String input = SCANNER.nextLine();
        System.out.println("보너스 볼을 입력해 주세요.");
        int bonus = SCANNER.nextInt();
        return new WinningLottoTicket(input, bonus);
    }
}
