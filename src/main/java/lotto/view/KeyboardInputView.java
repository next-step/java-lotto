package lotto.view;

import lotto.domain.LottoNumber;
import lotto.domain.LottoTicket;
import lotto.domain.PurchaseAmount;
import lotto.domain.PurchaseResult;

import java.io.InputStream;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class KeyboardInputView implements InputView {

    private final Scanner scanner;

    public KeyboardInputView(final InputStream source) {
        this.scanner = new Scanner(source);
    }

    @Override
    public PurchaseAmount getPurchaseAmount() {
        System.out.println("구입 금액을 입력해주세요.");
        int amount = Integer.parseInt(scanner.nextLine());
        return new PurchaseAmount(amount);
    }

    @Override
    public PurchaseResult getManualPurchasedTickets(final PurchaseAmount purchaseAmount) {  // 14000원, 14개
        System.out.println();
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        int manualPurchaseCounts = Integer.parseInt(scanner.nextLine());
        System.out.println();
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        List<LottoTicket> lottoTickets = IntStream.rangeClosed(1, manualPurchaseCounts)
                .mapToObj(i -> getLottoTicketInput())
                .collect(Collectors.toList());
        return PurchaseResult.of(lottoTickets, purchaseAmount.minus(manualPurchaseCounts));
    }

    @Override
    public LottoTicket getWinningTicket() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return getLottoTicketInput();
    }

    private LottoTicket getLottoTicketInput() {
        String inputText = scanner.nextLine();
        List<String> winningTicketNumbers = StringParser.split(inputText);
        List<LottoNumber> winningNumbers = winningTicketNumbers
                .stream()
                .map(LottoNumber::of)
                .collect(Collectors.toList());
        return new LottoTicket(winningNumbers);
    }

    @Override
    public LottoNumber getBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        String bonusNumberString = scanner.nextLine();
        return LottoNumber.of(bonusNumberString);
    }
}
