package lotto.view;

import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private static final int NO_MANUAL_LOTTO = 0;

    private final Scanner scanner = new Scanner(System.in);

    public int getPaidAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return Integer.parseInt(scanner.next());
    }

    public int getManualCount() {
        System.out.println();
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        scanner.nextLine();
        return Integer.parseInt(scanner.next());
    }

    public List<Lotto> getManualLottoNumbers(int manualTicketNo) {
        scanner.nextLine();
        List<Lotto> lottos = new ArrayList<>();

        if (manualTicketNo == NO_MANUAL_LOTTO) {
            return lottos;
        }

        System.out.println();
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");

        for (int i = 0; i < manualTicketNo; i++) {
            String numbers = scanner.nextLine();
            Lotto lotto = new Lotto(numbers);
            lottos.add(lotto);
        }
        return lottos;
    }

    public String getWinningNumbers() {
        System.out.println();
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return scanner.nextLine();
    }

    public int getBonusBall() {
        System.out.println();
        System.out.println("보너스 볼을 입력해 주세요.");
        return scanner.nextInt();
    }
}
