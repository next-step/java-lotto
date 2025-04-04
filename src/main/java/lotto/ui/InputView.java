package lotto.ui;

import lotto.domain.LottoNumber;
import lotto.domain.LottoTicket;
import lotto.domain.LottoTickets;
import lotto.domain.WinningLottoTicket;

import java.util.ArrayList;
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

    public static int inputManualLottoCount() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        return SCANNER.nextInt();
    }

    public static LottoTickets inputManualLottoTickets(int count) {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        String test = SCANNER.nextLine();
        LottoTickets lottoTickets = new LottoTickets();
        for(int i = 0; i < count; i++) {
            String input = SCANNER.nextLine();
            lottoTickets.addTicket(new LottoTicket(input));
        }
        return lottoTickets;
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
