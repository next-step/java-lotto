package lotto.view;

import lotto.domain.LottoNumber;
import lotto.domain.LottoTicket;
import lotto.domain.PurchaseAmount;

import java.io.InputStream;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class KeyboardInputView implements InputView {

    private final Scanner scanner;

    public KeyboardInputView(final InputStream source) {
        this.scanner = new Scanner(source);
    }

    public PurchaseAmount getPurchaseAmount() {
        System.out.println("구입 금액을 입력해주세요.");
        int amount = Integer.parseInt(scanner.nextLine());
        return new PurchaseAmount(amount);
    }

    public LottoTicket getWinningTicket() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String inputText = scanner.nextLine();
        List<String> winningTicketNumbers = StringParser.split(inputText);
        List<LottoNumber> winningNumbers = winningTicketNumbers
                .stream()
                .map(LottoNumber::of)
                .collect(Collectors.toList());
        return new LottoTicket(winningNumbers);
    }

    public LottoNumber getBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        String bonusNumberString = scanner.nextLine();
        return LottoNumber.of(bonusNumberString);
    }
}
