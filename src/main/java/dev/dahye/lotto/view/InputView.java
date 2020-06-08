package dev.dahye.lotto.view;

import dev.dahye.lotto.domain.LottoTicket;
import dev.dahye.lotto.util.ConvertUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final int ZERO_VALUE = 0;
    private static final Scanner scanner = new Scanner(System.in);

    public static int doInputMoney() {
        System.out.println("구입 금액을 입력하세요.");
        int purchaseAmount = Integer.parseInt(scanner.nextLine());

        return purchaseAmount;
    }

    public static int doInputCountOfManualLotto() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        int countOfManualLotto = Integer.parseInt(scanner.nextLine());

        return countOfManualLotto;
    }

    public static void printManualLottoInputHeader() {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
    }

    public static List<LottoTicket> doInputManualLotto(int countOfManualLotto) {
        List<LottoTicket> lottoTickets = new ArrayList<>();

        if (isExistManualLotto(countOfManualLotto)) {
            doInputManualLotto(countOfManualLotto, lottoTickets);
        }

        return lottoTickets;
    }

    private static void doInputManualLotto(int countOfManualLotto, List<LottoTicket> lottoTickets) {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");

        for (int i = 0; i < countOfManualLotto; i++) {
            lottoTickets.add(LottoTicket.manualIssued(ConvertUtils.convertStringToIntegerList(scanner.nextLine())));
        }
    }

    private static boolean isExistManualLotto(int countOfManualLotto) {
        return countOfManualLotto > ZERO_VALUE;
    }

    public static String doInputWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해주세요.");
        String winningNumbers = scanner.nextLine();

        return winningNumbers;
    }

    public static int doInputBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        int bonusNumber = Integer.parseInt(scanner.nextLine());

        return bonusNumber;
    }
}
