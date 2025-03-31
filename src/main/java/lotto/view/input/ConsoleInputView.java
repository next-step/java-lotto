package lotto.view.input;

import lotto.domain.PaymentReceipt;
import lotto.domain.product.LotteryTicket;
import lotto.domain.product.LottoNumber;
import lotto.domain.product.WinningTicket;

import java.util.Scanner;

public class ConsoleInputView extends BaseInputView {

    static Scanner scanner = new Scanner(System.in);

    @Override
    public String read() {
        return scanner.nextLine();
    }

    public PaymentReceipt purchase() {
        System.out.println("구입 금액을 입력 해 주세요.");
        return new PaymentReceipt(scanner.nextLine());
    }

    @Override
    public void closeScanner() {
        scanner.close();
    }

    @Override
    public WinningTicket getWinningTicket() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        LotteryTicket winningTicket = new LotteryTicket(parseToLottoNumbers(scanner.nextLine()));
        LottoNumber bonusNumber = getBonusNumber();
        return new WinningTicket(winningTicket, bonusNumber);
    }

    @Override
    public LottoNumber getBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return LottoNumber.of(scanner.nextLine());
    }
}
